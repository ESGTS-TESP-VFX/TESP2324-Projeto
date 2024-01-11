package com.tesp.tindogapp.apiService

import com.google.gson.annotations.SerializedName

data class UpdateProfileRequest (
    @SerializedName("nome") val nome: String,
    @SerializedName("image") val image: String,
    @SerializedName("descricao") val descricao: String,
)