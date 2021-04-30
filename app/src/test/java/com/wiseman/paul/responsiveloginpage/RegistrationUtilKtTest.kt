package com.wiseman.paul.responsiveloginpage

import org.junit.Test

import org.junit.Assert.*
import kotlin.math.acos

class RegistrationUtilKtTest {
    /**
     * the userphone number is not valid only if the it
     * ... does not start with 0
     * ... is greater than 11 digit
     * ... is less than 11 digit
     */
    @Test
    fun `PhoneNumber is valid only when the user input start with 0 and is 11 digit `(){
        val result = Validator.validatePhoneNumber("08155255365")
        assertTrue(result)
    }

    @Test
    fun `Valid PhoneNumber returns true`(){
        val result = Validator.validatePhoneNumber("08155255365")
        assertTrue(result)
    }

    @Test
    fun `phoneNumber not starting with 0 returns false`(){
        val result = Validator.validatePhoneNumber("98155255365")
        assertFalse(result)
    }

    @Test
    fun `phoneNumber greater than 11 digit returns false`(){
        val result = Validator.validatePhoneNumber("0981855255365")
        assertFalse(result)
    }

    @Test
    fun `phoneNumber less than 11 digit returns false`(){
        val result = Validator.validatePhoneNumber("0905255365")
        assertFalse(result)
    }


    /**
     * the user email is not valid if it
     * ... start with special character
     * ... does not contain the @ symbol
     * ... does not contain .
     * ... does not contain letters after the .(dot) symbol
     */
    @Test
    fun `valid useremail returns true`(){
        val result = Validator.validateEmail("emeka.paul@decagon.dev")
        assertTrue(result)
    }

    @Test
    fun `useremail starting with special character returns false`(){
        val result = Validator.validateEmail("*&emeka.paul@decagon.dev")
        assertFalse(result)
    }

    @Test
    fun `useremail not containing a (dot) returns false`(){
        val result = Validator.validateEmail("emekapaul@decagondev")
        assertFalse(result)
    }

    @Test
    fun `useremail not containing letters after the (dot) returns false`(){
        val result = Validator.validateEmail("emekapaul@decagon.")
        assertFalse(result)
    }


    /**
     *...the user input is only valid when valid username, phoneNumber email and gender is provided
     * the input is not valid if....
     * ...the username/email/gender/phone number is empty
     * ...the phone number is greater than 11
     * ...the phone is less than 11
     * ....phone number must start with 0 or 234
     *
     */
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