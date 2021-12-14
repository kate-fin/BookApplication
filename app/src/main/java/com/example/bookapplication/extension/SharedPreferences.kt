package com.example.bookapplication.extension

import android.content.SharedPreferences
import androidx.core.content.edit

var SharedPreferences.autologin: Boolean
    get() = getBoolean("autologin", false)
    set(value) = edit(true) { putBoolean("autologin", value) }

var SharedPreferences.login: String?
    get() = getString("login", null)
    set(value) = edit(true) { putString("login", value) }

var SharedPreferences.password: String?
    get() = getString("password", null)
    set(value) = edit(true) { putString("password", value) }