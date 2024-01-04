package com.tesp.tindogapp.apiService

import com.google.gson.annotations.SerializedName
import com.tesp.tindogapp.model.Dog
import com.tesp.tindogapp.model.Dog2
import com.tesp.tindogapp.model.Owner
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

public  interface ApiService {
    @POST("/token")
    fun getToken(@Body TokenRequest: TokenRequest ): Call<TokenResponse>

    @GET("/dogs")
    fun getDogs(@Header("Token") token: String): Call<List<Dog>>
    @GET("/dogs/{id}")
    fun getDog(@Header("Token")token: String,@Path("id") id: Int): Call<Dog>

    @GET("/dogs/{id}/match")
    fun getDogMatch(@Header("Token")token: String,@Path("id") id: Int): Call<Dog>

    @GET("/dogs2/{id}")
    fun getDog2(@Header("Token")token: String,@Path("id") id: Int): Call<Dog2>

    companion object{
        fun getInstance():ApiService{
            var apiService: ApiService?=null
            if (apiService == null){
                apiService = Retrofit.Builder()
                    .baseUrl("https://tindog.hugetower.tech/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ApiService::class.java)
            }

            return apiService!!;
        }
    }
}

data class TokenRequest (
    @SerializedName("Email") val email: String,
    @SerializedName("Password") val password: String,
)

data class TokenResponse(
    @SerializedName("email") val email: String,
    @SerializedName("token") val token: String
)

