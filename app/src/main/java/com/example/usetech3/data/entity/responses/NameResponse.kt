package com.example.usetech3.data.entity.responses

import com.example.usetech3.data.entity.Result
import com.google.gson.annotations.SerializedName

data class NameResponse(
    @SerializedName("response")
    val response: String,

    @SerializedName("results-for")
    val resultsFor: String,

    @SerializedName("results")
    val results: List<Result>,
)
