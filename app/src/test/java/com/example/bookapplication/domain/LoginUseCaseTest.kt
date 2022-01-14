package com.example.bookapplication.domain

import com.example.bookapplication.domain.enums.ValidLogin
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class LoginUseCaseTest {

    private val useCase = LoginUseCase()

    @Test
    fun `should check is empty login invalid`() {
        val expected = ValidLogin.EMPTY
        val actual = useCase.isValid("")
        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun `should check is login valid`() {
        val expected1 = ValidLogin.SUCCESS
        val actual1 = useCase.isValid("123")
        Assertions.assertEquals(expected1, actual1)
    }
}