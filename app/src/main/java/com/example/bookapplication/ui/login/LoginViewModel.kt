package com.example.bookapplication.ui.login

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bookapplication.extensions.autologin
import com.example.bookapplication.extensions.login
import com.example.bookapplication.extensions.password
import com.example.bookapplication.ui.login.models.IdentificatorUiState
import javax.inject.Inject


class LoginViewModel @Inject constructor(private val preferences: SharedPreferences) : ViewModel() {

    private val _uiStateAuthorization = MutableLiveData<IdentificatorUiState>()
    val uiStateAuthorization: LiveData<IdentificatorUiState> get() = _uiStateAuthorization

    fun autoLogin() {
        _uiStateAuthorization.postValue(IdentificatorUiState(isLoading = true))
        if (preferences.autologin) {
            _uiStateAuthorization.postValue(IdentificatorUiState(isLoading = false, isLoggedIn = true))
        } else {
            _uiStateAuthorization.postValue(IdentificatorUiState(isLoading = false))
        }
    }

    fun authorization(login: String, password: String, autologin: Boolean) {
        _uiStateAuthorization.postValue(IdentificatorUiState(isLoading = true))
        val loginHash = login.hashCode().toString()
        val passwordHash = password.hashCode().toString()
        if (preferences.login.isNullOrEmpty()) {
            preferences.login = loginHash
        }
        if (preferences.password.isNullOrEmpty()) {
            preferences.password = passwordHash
        }
        preferences.autologin = autologin
        _uiStateAuthorization.postValue(
            IdentificatorUiState(
                isLoading = false,
                isLoggedIn = loginHash == preferences.login && passwordHash == preferences.password)
            )
    }
}