package com.example.bookapplication.domain

import dagger.Provides
import java.util.regex.Pattern

class LoginUseCase {

    private val loginPattern = Pattern.compile("(?=\\S+$)")

    fun isValid(login: String): Boolean {
        return if (login.isEmpty()) {
            false
        } else if (loginPattern.matcher(login).matches()) {
            true
        } else {
            false
        }
    }
}