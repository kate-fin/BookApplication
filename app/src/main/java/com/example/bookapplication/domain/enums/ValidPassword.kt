package com.example.bookapplication.domain.enums

import com.example.bookapplication.R

enum class ValidPassword(val messageCode: Int) {
    SUCCESS(R.string.success_password),
    EMPTY(R.string.empty_password),
    WEAK(R.string.weak_password)
}