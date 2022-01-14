package com.example.bookapplication.domain

import com.example.bookapplication.domain.enums.ValidLogin

class LoginUseCase {

    fun isValid(login: String): ValidLogin {
        return if (login.isEmpty()) {
            ValidLogin.EMPTY
        } else {
            ValidLogin.SUCCESS
        }
    }
}