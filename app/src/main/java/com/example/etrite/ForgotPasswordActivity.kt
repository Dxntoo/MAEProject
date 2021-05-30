package com.example.etrite

import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_forgot_password.*

class ForgotPasswordActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        forgotPasswordBtn.setOnClickListener{
            val email: String = emailresetText.text.toString().trim{ it <= ' '}

            if(email.isEmpty()){
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_email), true)
            }else{

                showProgressDialog(resources.getString(R.string.please_wait))

                FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                    .addOnCompleteListener{ task ->

                        hideProgressDialog()

                        if(task.isSuccessful){
                            Toast.makeText(
                                this@ForgotPasswordActivity,
                                resources.getString(R.string.email_sent_success),
                                Toast.LENGTH_LONG
                            ).show()
                            finish()

                        }else{
                            showErrorSnackBar(task.exception!!.message.toString(), true)
                        }
                    }
            }
        }
    }


}