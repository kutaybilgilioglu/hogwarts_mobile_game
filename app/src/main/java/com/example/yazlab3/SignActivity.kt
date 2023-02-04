package com.example.yazlab3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.google.firebase.database.FirebaseDatabase


class SignActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign)
        var database = FirebaseDatabase.getInstance().reference
        val kaydolBtn = findViewById<View>(R.id.buton_kaydol2)
        kaydolBtn.setOnClickListener{
            val usernameTxt = findViewById<EditText>(R.id.editTextUsernameSign)
            val username = usernameTxt.text.toString()
            val passTxt = findViewById<EditText>(R.id.editTextPasswordSign)
            val pass = passTxt.text.toString()
            val passrTxt = findViewById<EditText>(R.id.editTextPasswordSignR)
            val passr = passrTxt.text.toString()
            if(pass == passr){
                database.child("users").push().setValue(Kullanici(username,pass))
            }


        }
    }
}