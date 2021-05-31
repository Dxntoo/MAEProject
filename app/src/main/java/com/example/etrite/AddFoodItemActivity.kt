package com.example.etrite

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_add_food_item.*

class AddFoodItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_food_item)

        val addfood = findViewById<View>(R.id.addFoodBtn)

        addfood.setOnClickListener{
            val alertDialog: AlertDialog = AlertDialog.Builder(this@AddFoodItemActivity).create()
            alertDialog.setTitle("Add Food?")
            alertDialog.setMessage("Are you sure you want to add this food?")
            alertDialog.setButton(
                AlertDialog.BUTTON_POSITIVE, "YES"
            ) { dialog, which -> onBackPressed() }
            alertDialog.setButton(
                AlertDialog.BUTTON_NEGATIVE, "NO"
            ) { dialog, which -> onBackPressed() }
            alertDialog.show()
        }

        val cancelBtn = findViewById<View>(R.id.cancelBtn)

        cancelBtn.setOnClickListener{
            onBackPressed()
        }
    }
}