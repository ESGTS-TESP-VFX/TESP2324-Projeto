package com.tesp.tindogapp.model

import com.google.gson.annotations.SerializedName

data class Dog (
    @SerializedName("Id") val Id: Int,
    @SerializedName("Nome") val Nome: String,
    @SerializedName("Idade") val Idade: Int,
    @SerializedName("Descricao") val Descricao: String,
    @SerializedName("Localidade")val Localidade: String,
    @SerializedName("Imagem")val Imagem: Int,
)


