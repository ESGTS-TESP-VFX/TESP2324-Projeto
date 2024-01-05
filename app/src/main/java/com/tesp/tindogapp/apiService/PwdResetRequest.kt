package com.tesp.tindogapp.apiService

import com.google.gson.annotations.SerializedName

data class PwdResetRequest (
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String,
    @SerializedName("recoverCode") val recoverCode: Int,
)