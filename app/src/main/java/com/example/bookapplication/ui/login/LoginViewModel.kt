package com.example.bookapplication.ui.login

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bookapplication.extension.autologin
import com.example.bookapplication.extension.login
import com.example.bookapplication.extension.password


class LoginViewModel(private val preferences: SharedPreferences) : ViewModel() {

    private val _haveAccess = MutableLiveData<Boolean>()
    val haveAccess: LiveData<Boolean> get() = _haveAccess

    fun autoLogin() {
        if (preferences.autologin) {
            _haveAccess.postValue(true)
        }
    }

    fun authorization(login: String, password: String, autologin: Boolean) {
        //TODO hash code
        val loginHash = ""
        val passwordHash = ""
        if (preferences.login.isNullOrEmpty()) {
            preferences.login = login
        }
        if (preferences.password.isNullOrEmpty()) {
            preferences.password = password
        }
        preferences.autologin = autologin
        _haveAccess.postValue(login == preferences.login && password == preferences.password)
    }
}