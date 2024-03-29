package com.tesp.tindogapp.apiService

import com.google.gson.annotations.SerializedName
import com.tesp.tindogapp.model.Dog
import com.tesp.tindogapp.model.Owner
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

public  interface ApiService {
    @POST("/Token")
    fun getToken(@Body TokenRequest: TokenRequest )
        : Call<TokenResponse>
    @POST("/SignUp")
    fun signUp(@Body SignUpRequest: SignUpRequest )
        :Call<SignUpResponse>
    @POST("/ResetPassword")
    fun resetPassword(@Body PwdResetRequest: PwdResetRequest )
        :Call<PwdResetResponse>
    @POST("/UpdateProfile")
    fun updateProfile(@Header("Token") token: String, @Body UpdateProfileRequest: UpdateProfileRequest )
        :Call<Owner>
    @GET("/Profile")
    fun getProfile(@Header("Token") token: String)
        :Call<Owner>

    @GET("/dog")
    fun getDogs(@Header("Token") token: String)
        :Call<List<Dog>>
    @POST("/dog")
    fun createDog(@Header("Token") token: String, @Body RegisterDogRequest: Dog )
        :Call<Dog>

    @PUT("/dog/{id}")
    fun updateDog(@Header("Token") token: String,@Path("id") id: Int, @Body RegisterDogRequest: Dog )
        :Call<Dog>

    @GET("/dog/{id}")
    fun getDog(@Header("Token")token: String,@Path("id") id: Int)
        : Call<Dog>

    @GET("/dog/{id}/CheckMatch")
    fun checkMatch(@Header("Token")token: String,@Path("id") id: Int,@Query("matchDog") matchDog: Int,@Query("match") match: Boolean)
        : Call<CheckMatchResponse>

    @GET("/dog/{id}/Match")
    fun askMatch(@Header("Token")token: String,@Path("id") id: Int,@Query("range") range: Int)
        : Call<CheckMatchResponse>

    @GET("/owners/{id}")
    fun getOwner(@Header("Token")token: String,@Path("id") id: Int): Call<Owner>


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


