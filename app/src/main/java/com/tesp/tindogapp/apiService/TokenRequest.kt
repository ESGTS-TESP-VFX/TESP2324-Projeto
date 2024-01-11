package com.tesp.tindogapp.apiService

import com.google.gson.annotations.SerializedName

data class TokenRequest (
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String,
)

