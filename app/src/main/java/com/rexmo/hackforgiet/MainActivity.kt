package com.rexmo.hackforgiet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //this will be used to access elements
        val etEmail:EditText=findViewById(R.id.etEmail)
        val etPassword:EditText=findViewById(R.id.etPassword)

        val button:Button=findViewById(R.id.button)
        button.setOnClickListener {
            //this variable will take input from the edit text in xml
            var email:String=etEmail.text.toString()
            var password:String=etPassword.text.toString()


            //Intent will act as a bridge between two Activitiea
            val i= Intent(this,SecondActivity::class.java)
            //Used to pass contents from one Activity to other
            i.putExtra("detail","$email $password")
            startActivity(i)
        }

    }
}