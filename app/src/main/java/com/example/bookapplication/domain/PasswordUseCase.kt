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
            // password.setError("Field can not be empty")
            ValidPassword.EMPTY
        }

        // if password does not matches to the pattern
        // it will display an error message "Password is too weak"
        else if (!passwordPattern.matcher(password).matches()) {
//            password.setError("Password is too weak")
            ValidPassword.WEAK
        } else {
//            password.setError(null)
            ValidPassword.SUCCESS
        }
    }
}