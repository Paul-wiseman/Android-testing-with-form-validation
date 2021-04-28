package com.wiseman.paul.responsiveloginpage

import org.junit.Test

import org.junit.Assert.*
import kotlin.math.acos

class RegistrationUtilKtTest {


    @Test
    fun `valid username,phoneNumber,email and gender returns true`() {
        val result = Validator.validateRegistrationInput(
                "oluola",
                "09015525620",
                "oluola@gmail.com",
                "Male"
        )
        assertTrue(result)
    }

    @Test
    fun `empty username returns false`() {
        val result = Validator.validateRegistrationInput(
                "",
                "09015525620",
                "oluola@gmail.com",
                "Male"
        )
        assertFalse(result)
    }

    @Test
    fun `empty phoneNumber returns false`() {
        val result = Validator.validateRegistrationInput(
                "Musa",
                "",
                "oluola@gmail.com",
                "Male"
        )
        assertFalse(result)
    }

    @Test
    fun `empty email returns false`() {
        val result = Validator.validateRegistrationInput(
                "Musa",
                "09015525620",
                "",
                "Male"
        )
        assertFalse(result)
    }
    @Test
    fun `empty gender selection returns false`() {
        val result = Validator.validateRegistrationInput(
                "Musa",
                "09015525620",
                "oluola@gmail.com",
                ""
        )
        assertFalse(result)

    }
    @Test
    fun `phone number not starting with 0 or 123 returns false`() {
        val result = Validator.validateRegistrationInput(
                "Musa",
                "59015525620",
                "oluola@gmail.com",
                "Male"
        )
        assertFalse(result)

    }
}