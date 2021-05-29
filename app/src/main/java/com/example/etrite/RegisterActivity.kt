package com.example.etrite

import android.os.Bundle
import android.text.TextUtils
import android.view.WindowManager
import android.widget.Toast
import com.example.etrite.firestore.FirestoreClass
import com.example.etrite.models.User
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_register.*
@Suppress("DEPRECATION")
class RegisterActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        supportActionBar?.hide()

        registerBtn.setOnClickListener{
            registerUser()
        }

    }

    private fun validateRegisterDetails(): Boolean {
        return when {
            TextUtils.isEmpty(usernameText.text.toString().trim { it <= ' ' }) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_username), true)
                false
            }

            TextUtils.isEmpty(emailText.text.toString().trim { it <= ' ' }) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_email), true)
                false
            }

            TextUtils.isEmpty(passwordText.text.toString().trim { it <= ' ' }) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_password), true)
                false
            }

            TextUtils.isEmpty(confirmPasswordText.text.toString().trim { it <= ' ' }) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_confirm_password), true)
                false
            }

            passwordText.text.toString().trim { it <= ' ' } != confirmPasswordText.text.toString()
                .trim { it <= ' ' } -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_password_and_confirm_password_mismatch), true)
                false
            }
            !cb_terms_and_condition.isChecked -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_agree_terms_and_condition), true)
                false
            }
            else -> {

                true
            }
        }
    }

    private fun registerUser(){
        if(validateRegisterDetails()){

            showProgressDialog(resources.getString(R.string.please_wait))


            val email: String = emailText.text.toString().trim { it <= ' ' }
            val password: String = passwordText.text.toString().trim { it <= ' ' }

            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(
                    OnCompleteListener<AuthResult>{ task ->

//
                    // If the registration is successfully done
                    if (task.isSuccessful) {

                        // Firebase registered user
                        val firebaseUser: FirebaseUser = task.result!!.user!!

                        val user = User(
                            firebaseUser.uid,
                            usernameText.text.toString().trim { it <= ' ' },
                            emailText.text.toString().trim { it <= ' ' }
                        )

                        FirestoreClass().registerUser(this@RegisterActivity, user)


                    } else {
                        hideProgressDialog()
                        // If the registering is not successful then show error message.

                        showErrorSnackBar(task.exception!!.message.toString(), true)
                    }
                })

        }

    }

    fun userRegistrationSuccess(){
        hideProgressDialog()

        Toast.makeText(
            this@RegisterActivity,
            resources.getString(R.string.register_success),
            Toast.LENGTH_SHORT
        ).show()

        FirebaseAuth.getInstance().signOut()
        finish()
    }
}