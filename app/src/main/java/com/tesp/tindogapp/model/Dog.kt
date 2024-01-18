package com.tesp.tindogapp.model


import android.net.Uri
import com.google.gson.annotations.SerializedName

data class Dog(
    @SerializedName("id") var Id: Int,
    @SerializedName("nome") var Nome: String,
    @SerializedName("idade") var Idade: Int,
    @SerializedName("descricao") var Descricao: String,
    @SerializedName("localidade") var Localidade: String,
    @SerializedName("imagem") var Imagem: String?,
    @SerializedName("raca") var Raca: String,
    @SerializedName("sexo") var Sexo: String,
    @SerializedName("chip") var Chip: Boolean,
    @SerializedName("vaccines") var Vacinas: List<String>?
)



