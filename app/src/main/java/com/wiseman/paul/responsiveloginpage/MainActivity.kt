package com.wiseman.paul.responsiveloginpage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val gender = resources.getStringArray(R.array.gender)
        val arrayAdapter = ArrayAdapter(this, R.layout.dropdown_item, gender )
        findViewById<AutoCompleteTextView>(R.id.login_page_selectgender).setAdapter(arrayAdapter)


        var name = findViewById<EditText>(R.id.login_page_userName)
        var phoneNumber =findViewById<EditText>(R.id.login_page_phoneNumber)
        var email = findViewById<EditText>(R.id.login_page_Email)
        var genderSelection = findViewById<AutoCompleteTextView>(R.id.login_page_selectgender)
        var btnRegister = findViewById<MaterialButton>(R.id.btnRegister)


        phoneNumber.doOnTextChanged { text, _, _, _ ->
            phoneNumber.error = null
//            phoneNumber.display
            Log.d("MainActivity", "onCreate: $text")

            if(text!!.length > 11) phoneNumber.error = "Invalid PhoneNumber, numbers must be equal 11"

        }





        btnRegister.setOnClickListener( View.OnClickListener {
           var username = name.text.toString()
            var userPhoneNumber = phoneNumber.text.toString()
            var userEmail = email.text.toString()
            var userGender = genderSelection.text.toString()

            val intent = Intent(this, ProfileActivity::class.java)
            intent.putExtra("userName", username)
            intent.putExtra("userPhone", userPhoneNumber)
            intent.putExtra("userEmail",userEmail)
            intent.putExtra("gender", userGender)


//            if (validatePhoneNumber(userPhoneNumber) && validateEmail(userEmail)){
//                startActivity(intent)
//            }else{
//                phoneNumber.error = "Invalid Input"
//                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
//            }

            if (Validator.validateRegistrationInput( username, userPhoneNumber, userEmail, userGender)) {

                startActivity(intent)
            } else {
                val errorMessage: String = Validator.error.errorMessage

                Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
            }



        })


    }
}