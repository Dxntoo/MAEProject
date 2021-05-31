package com.example.etrite

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_food_item.*


class FoodItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_item)
        supportActionBar?.hide()


        val logoutBtn = findViewById<View>(R.id.deleteFoodBtn)

        logoutBtn.setOnClickListener{
            val alertDialog: AlertDialog = AlertDialog.Builder(this@FoodItemActivity).create()
            alertDialog.setTitle("Delete Food?")
            alertDialog.setMessage("Are you sure you want to delete this food?")
            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "YES"
            ) { dialog, which -> onBackPressed() }
            alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "NO"
            ) { dialog, which -> onBackPressed() }
            alertDialog.show()
        }

        val cancelBtn = findViewById<View>(R.id.cancelBtn)

        cancelBtn.setOnClickListener{
            onBackPressed()
        }

    }
}