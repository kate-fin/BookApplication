package com.example.bookapplication.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BestSellersModel(
    val copyright: String,
    @SerialName("num_results")
    val numResults: Int,
    val results: List<BookModel>,
    val status: String
)

@Serializable
data class BookModel(
    @SerialName("age_group")
    val ageGroup: String,
    val author: String,
    val contributor: String,
    @SerialName("contributor_note")
    val contributorNote: String,
    val description: String,
//    isbns:array[object:]
    val price: Float,
    val publisher: String,
//ranks_history:array[object:]
//reviews:array[object:]
    val title: String
)