package com.example.bookapplication.ui.login

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bookapplication.extension.autologin
import com.example.bookapplication.extension.login
import com.example.bookapplication.extension.password
import javax.inject.Inject


class LoginViewModel @Inject constructor(private val preferences: SharedPreferences) : ViewModel() {

    private val _haveAccess = MutableLiveData<Boolean>()
    val haveAccess: LiveData<Boolean> get() = _haveAccess

    fun autoLogin() {
        if (preferences.autologin) {
            _haveAccess.postValue(true)
        }
    }

    fun authorization(login: String, password: String, autologin: Boolean) {
        val loginHash = login.hashCode().toString()
        val passwordHash = password.hashCode().toString()
        if (preferences.login.isNullOrEmpty()) {
            preferences.login = loginHash
        }
        if (preferences.password.isNullOrEmpty()) {
            preferences.password = passwordHash
        }
        preferences.autologin = autologin
        _haveAccess.postValue(loginHash == preferences.login && passwordHash == preferences.password)
    }
}