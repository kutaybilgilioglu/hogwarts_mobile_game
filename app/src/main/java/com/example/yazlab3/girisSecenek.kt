package com.example.yazlab3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent
import android.view.Gravity
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue
import android.util.Base64;

class girisSecenek : AppCompatActivity() {
    var game_mode = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_giris_secenek)
        val chip_x2 = findViewById<View>(R.id.chip_x2)
        val chip_x4 = findViewById<View>(R.id.chip_x4)
        val chip_x6 = findViewById<View>(R.id.chip_x6)
        val btn_start = findViewById<View>(R.id.button_start)
        val btn_menu = findViewById<View>(R.id.mainmenuButton)
        chip_x2.setOnClickListener{

            game_mode = 2
            println(game_mode)
        }
        chip_x4.setOnClickListener{
            game_mode = 4
        }
        chip_x6.setOnClickListener{
            game_mode = 6
        }

        btn_menu.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        btn_start.setOnClickListener{
            val intent = Intent(this,gameActivity::class.java)
            intent.putExtra("game_mode",game_mode)
            startActivity(intent)

        }


    }

}