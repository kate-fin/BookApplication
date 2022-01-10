package com.example.bookapplication.ui.settings

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bookapplication.extension.autologin
import com.example.bookapplication.extension.login
import com.example.bookapplication.extension.password
import javax.inject.Inject


class SettingsViewModel @Inject constructor(private val preferences: SharedPreferences) :
    ViewModel() {

    fun saveLogin(login: String) {
        //TODO при пустоте ""
        preferences.login = login.hashCode().toString()
    }

    fun savePassword(password: String) {
        preferences.password = password.hashCode().toString()
    }

    fun saveAutologin(isAutologin: Boolean) {
        preferences.autologin = isAutologin
    }
}