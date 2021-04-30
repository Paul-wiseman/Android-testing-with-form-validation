package com.wiseman.paul.responsiveloginpage


object Validator {

    lateinit var error: Error

    /**
     * the userphone number is valid only if the it
     * ... start with 0
     * ... is 11 digit
     *
     */
    fun validatePhoneNumber(phoneNumber : String) : Boolean{
        val pattern = Regex("^[0]\\d{10}\$")

        return pattern.matches(phoneNumber)
    }

    fun validateEmail(email: String): Boolean{
        val  pattern = Regex("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")
        return pattern.matches(email)
    }


    /**
     * the input is not valid if....
     * ...the username/email/gender/phone number is empty
     * ...the phone number is greater than 11
     * ...the phone is less than 11
     * ....phone number must start with 0 or 234
     */
    fun validateRegistrationInput( userName:String, phoneNumber: String, email: String, gender:String): Boolean{
        if (userName.trim().isEmpty()) {
            error = Error("username", "username can't be empty")
            return false
        } else if (!validatePhoneNumber(phoneNumber)) {
            error = Error("phone", "phone number is incorrect")
            return false
        }
        else if (!validateEmail(email)) {
            error = Error("email", "invalid email")
            return false
        }else if (gender.trim().isEmpty()) {
            error = Error("username", "gender can't be empty")
            return false
        }

        return true
    }
}
