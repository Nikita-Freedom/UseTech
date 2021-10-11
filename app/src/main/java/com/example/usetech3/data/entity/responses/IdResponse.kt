package com.example.usetech3.data.entity.responses

import com.example.usetech3.data.entity.*
import com.google.gson.annotations.SerializedName

data class IdResponse(
    @SerializedName("response")
    val response: String,

    @SerializedName("id")
    val id: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("powerstats")
    val powerStats: Powerstats,

    @SerializedName("biography")
    val biography: Biography,


    @SerializedName("appearance")
    val appearance: Appearance,

    @SerializedName("work")
    val work: Work,

    @SerializedName("connections")
    val connections: Connections,

    @SerializedName("image")
    val image: Image
)
