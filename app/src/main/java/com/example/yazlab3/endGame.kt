package com.example.yazlab3

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class endGame : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end_game)
        var lose = intent.getBooleanExtra("timeout",false)
        var lose_sound:MediaPlayer = MediaPlayer.create(this,R.raw.lose)
        var won_sound:MediaPlayer = MediaPlayer.create(this,R.raw.won)
        var button = findViewById<View>(R.id.buttonMenu)
        var textWon = findViewById<TextView>(R.id.textWon)

        if(lose){
            textWon.text = "Süren Bitti, Kaybettin!!!"
            lose_sound.start()
        }
        else{
            textWon.text = "Kazandın!!!"
            won_sound.start()
        }
        button.setOnClickListener{
            val intent = Intent(this,girisSecenek::class.java)
            startActivity(intent)
        }
    }
}