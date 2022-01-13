package com.example.bookapplication.domain

import com.example.bookapplication.domain.enums.ValidLogin
import dagger.Provides
import java.util.regex.Pattern

class LoginUseCase {

    fun isValid(login: String): ValidLogin {
        return if (login.isEmpty()) {
            ValidLogin.EMPTY
        } else {
            ValidLogin.SUCCESS
        }
    }
}