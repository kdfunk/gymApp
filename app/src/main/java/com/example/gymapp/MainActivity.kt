package com.example.gymapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var Email: EditText
    private lateinit var Password: EditText
    private lateinit var Info: TextView
    private lateinit var Login: Button
    private var counter = 10

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Email = findViewById(R.id.etEmail)
        Password = findViewById(R.id.etPassword)
        Info = findViewById(R.id.tvInfo)
        Login = findViewById(R.id.btnLogin)

        Info.text = "Number of attempts remaining is: 10"

        Login.setOnClickListener {
            validate(Email.text.toString(), Password.text.toString())
        }
    }

    private fun validate(userEmail: String, userPassword: String) {
        if (userEmail == "Admin" && userPassword == "1234") {
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            startActivity(intent)
        } else {
            counter--

            Info.text = "Number of attempts remaining: $counter"
            if (counter == 0) {
                Login.isEnabled = false
            }
        }
    }
}
