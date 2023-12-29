package com.tesp.tindogapp.model

import android.net.Uri
import com.google.gson.annotations.SerializedName

data class Dog (
    @SerializedName("id") val Id: Int,
    @SerializedName("nome") val Nome: String,
    @SerializedName("idade") val Idade: Int,
    @SerializedName("descricao") var Descricao: String,
    @SerializedName("localidade")val Localidade: String,
    @SerializedName("imagem")val Imagem: Int,
)

data class Dog2(
    @SerializedName("id") val Id: Int,
    @SerializedName("nome") var Nome: String,
    var ImageUri: Uri?,
    var Desc: String,
    var Localidade: String,
    var Idade: Int?,
    var Raca: String,
    var Sexo:String,
)


