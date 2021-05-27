package com.example.dantoo

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.dantoo.databinding.ActivityLoginBinding
import com.example.dantoo.firestore.FirestoreClass
import com.example.dantoo.models.User
import com.example.dantoo.ui.profile.ProfileFragment
import com.example.dantoo.utils.Constants
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.fragment_profile.*

@Suppress("DEPRECATION")
class LoginActivity : BaseActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        supportActionBar?.hide()

        signupBtn.setOnClickListener{

            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
        }



        forgotPasswordText.setOnClickListener(this)
        // Click event assigned to Login button.
        loginBtn.setOnClickListener(this)
        // Click event assigned to Register text.
        signupBtn.setOnClickListener(this)

        
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {

                R.id.forgotPasswordText -> {

                    val intent = Intent(this@LoginActivity, ForgotPasswordActivity::class.java)
                    startActivity(intent)
                }

                R.id.loginBtn -> {


                    logInRegisteredUser()

                }

                R.id.signupBtn -> {
                    // Launch the register screen when the user clicks on the text.
                    val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }

    private fun validateLoginDetails(): Boolean {
        return when {
            TextUtils.isEmpty(emailTextField.text.toString().trim { it <= ' ' }) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_email), true)
                false
            }
            TextUtils.isEmpty(passwordTextField.text.toString().trim { it <= ' ' }) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_password), true)
                false
            }
            else -> {
                showErrorSnackBar("Your details are valid.", false)
                true
            }
        }
    }


    private fun logInRegisteredUser() {

        if (validateLoginDetails()) {

            // Show the progress dialog.
            showProgressDialog(resources.getString(R.string.please_wait))

            // Get the text from editText and trim the space
            val email = emailTextField.text.toString().trim { it <= ' ' }
            val password = passwordTextField.text.toString().trim { it <= ' ' }

            // Log-In using FirebaseAuth
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->

                    if (task.isSuccessful) {

                        FirestoreClass().getUserDetails(this@LoginActivity)

                        // END
                    } else {
                        // Hide the progress dialog
                        hideProgressDialog()
                        showErrorSnackBar(task.exception!!.message.toString(), true)
                    }
                }
        }
    }


    fun userLoggedInSuccess(user: User) {

        // Hide the progress dialog.
        hideProgressDialog()

        // Print the user details in the log as of now.
        Log.i("Username: ", user.username)
        Log.i("Email: ", user.email)


        startActivity(Intent(this@LoginActivity, Dashboard::class.java))

        finish()

    }

}