package com.example.yazlab3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class passReset : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pass_reset)
        var button = findViewById<View>(R.id.button_change)
        var database = FirebaseDatabase.getInstance().reference
        button.setOnClickListener {
            val usernameTxt = findViewById<EditText>(R.id.editTextTextPersonName2)
            val username = usernameTxt.text.toString()
            val passTxt = findViewById<EditText>(R.id.editTextTextPassword2)
            val pass = passTxt.text.toString()
            val new_pass_txt = findViewById<EditText>(R.id.editTextTextPassword3)
            val new_pass = new_pass_txt.text.toString()
            if(readData(username,pass)){

                Toast.makeText(applicationContext,"success", Toast.LENGTH_SHORT).show()
            }
        }

    }
    private fun readData(userName: String,pass: String):Boolean {
        var success:Boolean = false
        var dbref = FirebaseDatabase.getInstance().getReference("users")
        var dbref2 = FirebaseDatabase.getInstance().getReference("users")
        val password = findViewById<View>(R.id.editTextTextPassword).toString()
        dbref.orderByChild("username").equalTo(userName).addValueEventListener(object:
            ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    //val pass = snapshot.child("password").value
                    dbref2.orderByChild("password").equalTo(pass).addValueEventListener(object:
                        ValueEventListener {
                        override fun onDataChange(snapshot: DataSnapshot) {
                            if(snapshot.exists()){

                                success = true


                            }
                            else{
                                success = false
                                Toast.makeText(applicationContext,"kullanici adi veya sifre yanlis",
                                    Toast.LENGTH_SHORT).show()

                            }
                        }

                        override fun onCancelled(error: DatabaseError) {
                            TODO("Not yet implemented")
                        }

                    })


                }
                else{
                    success = false
                    Toast.makeText(applicationContext,"kullanici adi veya sifre yanlis", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
        return success
    }
}