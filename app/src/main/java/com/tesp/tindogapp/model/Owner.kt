package com.tesp.tindogapp.model

import android.net.Uri
import com.google.gson.annotations.SerializedName

class Owner(
    @SerializedName("id") val Id: Int,
    @SerializedName("nome") var Nome: String,
    @SerializedName("email") var Email: String,
    @SerializedName("descricao") var Descricao: String,
    var ImageUri: Uri?,
) {
}