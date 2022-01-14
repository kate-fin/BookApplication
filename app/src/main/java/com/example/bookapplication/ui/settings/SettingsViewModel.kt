package com.example.bookapplication.ui.settings

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bookapplication.domain.LoginUseCase
import com.example.bookapplication.domain.PasswordUseCase
import com.example.bookapplication.domain.enums.ValidLogin
import com.example.bookapplication.domain.enums.ValidPassword
import com.example.bookapplication.extensions.autologin
import com.example.bookapplication.extensions.login
import com.example.bookapplication.extensions.password
import com.example.bookapplication.ui.settings.models.ChangeIdentificatorUiState
import javax.inject.Inject


class SettingsViewModel @Inject constructor(private val preferences: SharedPreferences,
                                            private val loginUseCase: LoginUseCase,
                                            private val passwordUseCase: PasswordUseCase) : ViewModel() {

    private val _uiStateLogin = MutableLiveData<ChangeIdentificatorUiState>()
    val uiStateLogin: LiveData<ChangeIdentificatorUiState> get() = _uiStateLogin
    private val _uiStatePassword = MutableLiveData<ChangeIdentificatorUiState>()
    val uiStatePassword: LiveData<ChangeIdentificatorUiState> get() = _uiStatePassword

    fun saveLogin(login: String) {
        _uiStateLogin.postValue(ChangeIdentificatorUiState(isLoading = true))
        val isValid = loginUseCase.isValid(login)
        if (isValid == ValidLogin.SUCCESS) {
            preferences.login = login.hashCode().toString()
        }
        _uiStateLogin.postValue(ChangeIdentificatorUiState(isLoading = false, errorMessageCode = isValid.messageCode))
    }

    fun savePassword(password: String) {
        _uiStatePassword.postValue(ChangeIdentificatorUiState(isLoading = true))
        val isValid = passwordUseCase.isValid(password)
        if (isValid == ValidPassword.SUCCESS) {
            preferences.password = password.hashCode().toString()
        }
        _uiStatePassword.postValue(ChangeIdentificatorUiState(isLoading = false, errorMessageCode = isValid.messageCode))
    }

    fun saveAutologin(isAutologin: Boolean) {
        preferences.autologin = isAutologin
    }
}