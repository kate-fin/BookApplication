package com.example.bookapplication.source.remote.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookNetModel(
    @SerialName("age_group")
    val ageGroup: String,
    val author: String,
    val contributor: String,
    @SerialName("contributor_note")
    val contributorNote: String,
    val description: String?,
//    isbns:array[object:]
    val price: Float,
    val publisher: String,
//ranks_history:array[object:]
//reviews:array[object:]
    val title: String
)