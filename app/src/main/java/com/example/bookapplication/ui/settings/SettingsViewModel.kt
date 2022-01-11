package com.example.bookapplication.ui.settings

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bookapplication.domain.LoginUseCase
import com.example.bookapplication.domain.PasswordUseCase
import com.example.bookapplication.extension.autologin
import com.example.bookapplication.extension.login
import com.example.bookapplication.extension.password
import javax.inject.Inject


class SettingsViewModel @Inject constructor(private val preferences: SharedPreferences,
                                            private val loginUseCase: LoginUseCase,
                                            private val passwordUseCase: PasswordUseCase) : ViewModel() {

    fun saveLogin(login: String) {
        if (loginUseCase.isValid(login)) {
            preferences.login = login.hashCode().toString()
        } else {
            TODO()
        }
    }

    fun savePassword(password: String) {
        if (passwordUseCase.isValid(password)) {
            preferences.password = password.hashCode().toString()
        } else {
            TODO()
        }
    }

    fun saveAutologin(isAutologin: Boolean) {
        preferences.autologin = isAutologin
    }
}