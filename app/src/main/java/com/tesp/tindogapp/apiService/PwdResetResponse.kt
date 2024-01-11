package com.tesp.tindogapp.apiService

import com.google.gson.annotations.SerializedName

data class PwdResetResponse(
    @SerializedName("email") val email: String,
    @SerializedName("token") val token: String,
    @SerializedName("userId") val userId: Int
)
