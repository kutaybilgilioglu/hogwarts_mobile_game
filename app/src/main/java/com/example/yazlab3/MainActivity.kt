package com.example.yazlab3

import android.app.Service
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.view.Gravity
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue
import com.google.firebase.database.ktx.snapshots


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val player = Intent(this,myService::class.java)
        startService(player)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var database = FirebaseDatabase.getInstance().reference
        val kaydolBtn = findViewById<View>(R.id.buton_kaydol)
        val girisBtn = findViewById<View>(R.id.buuton_giris)
        val sifre_Btn = findViewById<View>(R.id.button_pass_reset)

        sifre_Btn.setOnClickListener {
            val intent = Intent(this,passReset::class.java)
            startActivity(intent)
        }

        kaydolBtn.setOnClickListener{

            val intent = Intent(this,SignActivity::class.java)
            startActivity(intent)
        }

        girisBtn.setOnClickListener{
            val usernameTxt = findViewById<EditText>(R.id.editTextTextPersonName)
            val username = usernameTxt.text.toString()
            val passTxt = findViewById<EditText>(R.id.editTextTextPassword)
            val pass = passTxt.text.toString()
            readData(username,pass)
        }




    }
    private fun readData(userName: String,pass: String) {

        var dbref = FirebaseDatabase.getInstance().getReference("users")
        var dbref2 = FirebaseDatabase.getInstance().getReference("users")
        val password = findViewById<View>(R.id.editTextTextPassword).toString()
        dbref.orderByChild("username").equalTo(userName).addValueEventListener(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    //val pass = snapshot.child("password").value
                    dbref2.orderByChild("password").equalTo(pass).addValueEventListener(object:ValueEventListener{
                        override fun onDataChange(snapshot: DataSnapshot) {
                            if(snapshot.exists()){

                                val intent = Intent(this@MainActivity,girisSecenek::class.java)
                                startActivity(intent)
                                Toast.makeText(applicationContext,"success",Toast.LENGTH_SHORT).show()
                            }
                            else{
                                Toast.makeText(applicationContext,"kullanici adi veya sifre yanlis",Toast.LENGTH_SHORT).show()
                            }
                        }

                        override fun onCancelled(error: DatabaseError) {
                            TODO("Not yet implemented")
                        }

                    })


                }
                else{
                    Toast.makeText(applicationContext,"kullanici adi veya sifre yanlis",Toast.LENGTH_SHORT).show()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }


}