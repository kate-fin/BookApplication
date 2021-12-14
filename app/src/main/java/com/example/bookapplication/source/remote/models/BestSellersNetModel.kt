package com.example.bookapplication.source.remote.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BestSellersNetModel(
    val copyright: String,
    @SerialName("num_results")
    val numResults: Int,
    val results: List<BookNetModel>,
    val status: String
)
