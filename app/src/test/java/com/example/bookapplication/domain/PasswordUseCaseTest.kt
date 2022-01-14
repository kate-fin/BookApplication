package com.example.bookapplication.domain

import com.example.bookapplication.domain.enums.ValidPassword
import com.google.android.gms.common.internal.Asserts
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.lang.AssertionError
import java.util.regex.Pattern

class PasswordUseCaseTest {
    private val passwordUseCase = PasswordUseCase()

    @Test
    fun `empty password test`() {
        val expected = ValidPassword.EMPTY
        val actual = passwordUseCase.isValid("")
        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun `short password test`() {
        val expected = ValidPassword.WEAK
        val actual = passwordUseCase.isValid("12")
        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun `without special symbols password test`() {
        val expected = ValidPassword.WEAK
        val actual = passwordUseCase.isValid("1234")
        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun `success password test`() {
        val expected = ValidPassword.SUCCESS
        val actual = passwordUseCase.isValid("1234#")
        Assertions.assertEquals(expected, actual)
    }
}