package com.tesp.tindogapp.model

import android.net.Uri
import com.google.gson.annotations.SerializedName

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