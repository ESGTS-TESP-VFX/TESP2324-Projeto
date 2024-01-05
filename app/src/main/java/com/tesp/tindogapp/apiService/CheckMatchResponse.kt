package com.tesp.tindogapp.apiService

import com.google.gson.annotations.SerializedName
import com.tesp.tindogapp.model.Dog
import com.tesp.tindogapp.model.Owner

data class CheckMatchResponse(
    @SerializedName("hadMatched") val HadMatched: Boolean,
    @SerializedName("dog") val Dog: Dog,
    @SerializedName("owner") val Owner: Owner
)