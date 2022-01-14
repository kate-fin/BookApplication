package com.example.bookapplication.domain

import com.example.bookapplication.domain.enums.ValidPassword
import java.util.regex.Pattern

class PasswordUseCase {
    private val passwordPattern: Pattern = Pattern.compile(
        "^" +
                "(?=.*[@#$%^&+=])" +  // at least 1 special character
                "(?=\\S+$)" +  // no white spaces
                ".{4,}" +  // at least 4 characters
                "$"
    )

    fun isValid(password: String): ValidPassword {
        return if (password.isEmpty()) {
            ValidPassword.EMPTY
        } else if (!passwordPattern.matcher(password).matches()) {
            ValidPassword.WEAK
        } else {
            ValidPassword.SUCCESS
        }
    }
}