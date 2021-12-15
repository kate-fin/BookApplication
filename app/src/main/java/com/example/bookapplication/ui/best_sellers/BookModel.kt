package com.example.bookapplication.ui.best_sellers

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BookModel(
    val title: String,
    val author: String,
    var isFavourite: Boolean
): Parcelable
