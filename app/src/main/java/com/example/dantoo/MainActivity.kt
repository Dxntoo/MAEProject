package com.example.dantoo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.dantoo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.loginBtn.setOnClickListener {
            val email = binding.emailTextField.text.toString()
            val password = binding.passwordTextField.text.toString()

            Log.d("Email is: ", email)
            Log.d("Password is: ", password)

            val intent = Intent(this, Dashboard::class.java)

            startActivity(intent)
        }



        
    }



}