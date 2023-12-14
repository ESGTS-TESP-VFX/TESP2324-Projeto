package com.tesp.tindogapp.apiService

import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

public  interface ApiService {
    @GET("api/token")
    fun getToken(): Call<TokenResponse>

    companion object{
        fun getInstance():ApiService{
            var apiService: ApiService?=null

            if (apiService == null){
                apiService = Retrofit.Builder()
                    .baseUrl("https://ac1f38b9-e49a-4f67-a964-c22a73af60de.mock.pstmn.io/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ApiService::class.java)
            }

            return apiService!!;
        }
    }
}

data class TokenResponse(
    @SerializedName("Email") val email: String,
    @SerializedName("Passowrd") val password: String,
    @SerializedName("Token") val token: String
)

