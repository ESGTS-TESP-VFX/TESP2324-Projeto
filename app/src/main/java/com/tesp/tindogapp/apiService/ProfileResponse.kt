package com.tesp.tindogapp.apiService

import com.google.gson.annotations.SerializedName

data class ProfileResponse (
    @SerializedName("nome") val nome: String,
    @SerializedName("image") val image: String,
    @SerializedName("descricao") val descricao: String,
    @SerializedName("id") val id: Int,
    @SerializedName("email") val email: String,
)