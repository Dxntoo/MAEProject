package com.example.etrite

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.google.firebase.auth.FirebaseAuth
import com.example.etrite.firestore.FirestoreClass
import com.example.etrite.models.User
import com.example.etrite.utils.Constants
import com.example.etrite.utils.GlideLoader
import kotlinx.android.synthetic.main.activity_profile.*

/**
 * Setting screen of the app.
 */
class ProfileActivity : BaseActivity(), View.OnClickListener {
    private lateinit var mUserDetails: User
    override fun onCreate(savedInstanceState: Bundle?) {
        //This call the parent constructor
        super.onCreate(savedInstanceState)
        // This is used to align the xml view to this class
        setContentView(R.layout.activity_profile)
        supportActionBar?.hide()
        editProfileBtn.setOnClickListener(this@ProfileActivity)
        saveBtn.setOnClickListener(this@ProfileActivity)
    }

    override fun onResume() {
        super.onResume()

        getUserDetails()
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {

                R.id.editProfileBtn -> {
                    val intent = Intent(this@ProfileActivity, UserProfileActivity::class.java)
                    intent.putExtra(Constants.EXTRA_USER_DETAILS, mUserDetails)
                    startActivity(intent)
                }

                R.id.saveBtn -> {

                    FirebaseAuth.getInstance().signOut()

                    val intent = Intent(this@ProfileActivity, LoginActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                    finish()
                }
            }
        }
    }


    /**
     * A function to get the user details from firestore.
     */
    private fun getUserDetails() {

        // Show the progress dialog
        showProgressDialog(resources.getString(R.string.please_wait))

        // Call the function of Firestore class to get the user details from firestore which is already created.
        FirestoreClass().getUserDetails(this@ProfileActivity)
    }

    /**
     * A function to receive the user details and populate it in the UI.
     */
    fun userDetailsSuccess(user: User) {

        mUserDetails = user

        // Hide the progress dialog
        hideProgressDialog()

        // Load the image using the Glide Loader class.
        GlideLoader(this@ProfileActivity).loadUserPicture(user.image, iv_user_photo)

        usernameTitle.text = user.username
        genderTitle.text = user.gender
        emailTitle.text = user.email
        phoneTitle.text = "${user.mobile}"
    }
}