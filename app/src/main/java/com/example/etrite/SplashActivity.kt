package com.example.etrite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import com.example.etrite.firestore.FirestoreClass

@Suppress("DEPRECATION")
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash)

        supportActionBar?.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        Handler().postDelayed({

            val currentUserID = FirestoreClass().getCurrentUserID()

            if(currentUserID.isNotEmpty()){
                startActivity(Intent(this@SplashActivity, Dashboard::class.java))
            }else{
                startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
            }

            finish() // Call this when your activity is done and should be closed.


        }, 2500)
    }


}