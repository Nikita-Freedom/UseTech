package com.example.usetech3.data.entity

import com.google.gson.annotations.SerializedName

data class Connections(
    @SerializedName("group-affiliation")
    val groupAffiliation: String,

    @SerializedName("relatives")
    var relatives: String
)
