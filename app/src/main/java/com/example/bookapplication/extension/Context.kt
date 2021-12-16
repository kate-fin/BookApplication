package com.example.bookapplication.extension

import android.content.Context
import android.content.SharedPreferences
import com.example.bookapplication.MainApplication
import com.example.bookapplication.di.AppComponent

val Context.preferences: SharedPreferences
    get() = getSharedPreferences("book_app", Context.MODE_PRIVATE)

val Context.appComponent: AppComponent
    get() = when (this) {
        is MainApplication -> appComponent
        else -> this.applicationContext.appComponent
    }