package com.example.bookapplication.extension

import android.content.Context
import android.content.SharedPreferences

val Context.preferences: SharedPreferences?
get() = getSharedPreferences("book_app", Context.MODE_PRIVATE)