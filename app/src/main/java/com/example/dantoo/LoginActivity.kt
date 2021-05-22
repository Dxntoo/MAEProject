package com.example.dantoo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.example.dantoo.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()


        binding.loginBtn.setOnClickListener {
            val email = binding.emailTextField.text.toString()
            val password = binding.passwordTextField.text.toString()

            Log.d("Email is: ", email)
            Log.d("Password is: ", password)

            login()


        }

        binding.registerBtn.setOnClickListener{
            val registerIntent = Intent(this, RegisterActivity::class.java)
            startActivity(registerIntent)
        }



        
    }

    //Create a login function
    private fun login(){

        //initialize var
        val email = binding.emailTextField.text.toString();
        val password = binding.passwordTextField.text.toString();

        if(email == "danishzwordan@gmail.com" && password == "qwerty123"){
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
        }else{
            val message = "";
            Log.d(message,"Error")
        }
    }

    private fun loginVerification(){

    }

}