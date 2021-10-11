package com.example.usetech3.data.entity

import com.google.gson.annotations.SerializedName

data class Powerstats(
    //var resultGson: ResultGson,
    @SerializedName("intelligence")
    val intelligence: String,

    @SerializedName("strength")
    val strength: String,

    @SerializedName("speed")
    val speed: String,

    @SerializedName("durability")
    val durability: String,

    @SerializedName("power")
    val power: String,

    @SerializedName("combat")
    val combat: String
)
