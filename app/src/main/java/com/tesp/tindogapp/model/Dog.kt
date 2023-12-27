package com.tesp.tindogapp.model

import com.google.gson.annotations.SerializedName

data class Dog (
    @SerializedName("id") val Id: Int,
    @SerializedName("nome") val Nome: String,
    @SerializedName("idade") val Idade: Int,
    @SerializedName("descricao") val Descricao: String,
    @SerializedName("localidade")val Localidade: String,
    @SerializedName("imagem")val Imagem: Int,
)


