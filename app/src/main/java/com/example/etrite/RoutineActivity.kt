package com.example.etrite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class RoutineActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_routine)
        supportActionBar?.hide()
    }
}