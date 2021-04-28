package com.wiseman.paul.responsiveloginpage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)


        var profileName = findViewById<TextView>(R.id.profile_page_userName)
        var profilePhoneNumber = findViewById<TextView>(R.id.profile_page_phoneNumber)
        var profileEmail = findViewById<TextView>(R.id.profile_page_Email)
        var profileGender = findViewById<TextView>(R.id.profile_page_gender)


        var username = intent.getStringExtra("userName")
        var userPhoneNumber = intent.getStringExtra("userPhone")
        var userEmail = intent.getStringExtra("userEmail")
        var userGender = intent.getStringExtra("gender")

        profileName.text = username
        profilePhoneNumber.text = userPhoneNumber
        profileEmail.text = userEmail
        profileGender.text = userGender

    }
}

