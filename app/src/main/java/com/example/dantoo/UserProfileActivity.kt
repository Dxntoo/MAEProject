package com.example.dantoo

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.dantoo.firestore.FirestoreClass
import com.example.dantoo.models.User
import com.example.dantoo.utils.Constants
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_user_profile.*
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.fragment_profile.profilePicture

class UserProfileActivity : BaseActivity(), View.OnClickListener {
    private lateinit var muserDetails: User

    private var mSelectedImageFileUri: Uri? = null

    private var mUserProfileImageURL: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        if(intent.hasExtra(Constants.EXTRA_USER_DETAILS)){
            muserDetails = intent.getParcelableExtra(Constants.EXTRA_USER_DETAILS)!!
        }

        profileUsernameText.isEnabled = false
        profileUsernameText.setText(muserDetails.username)


        emailText.isEnabled = false
        emailText.setText(muserDetails.email)

        profilePicture.setOnClickListener(this@UserProfileActivity)
        completeProfileBtn.setOnClickListener(this@UserProfileActivity)
    }

    override fun onClick(v: View?) {
        if (v!=null){
            when(v.id){
                R.id.profilePicture ->{
                    if (ContextCompat.checkSelfPermission(
                            this,
                            Manifest.permission.READ_EXTERNAL_STORAGE
                        )
                        == PackageManager.PERMISSION_GRANTED
                    ) {

                        Constants.showImageChooser(this@UserProfileActivity)
                    } else {

                        /*Requests permissions to be granted to this application. These permissions
                         must be requested in your manifest, they should not be granted to your app,
                         and they should have protection level*/

                        ActivityCompat.requestPermissions(
                            this,
                            arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                            Constants.READ_STORAGE_PERMISSION_CODE
                        )
                    }
                }

                R.id.completeProfileBtn ->{

                    showProgressDialog(resources.getString(R.string.please_wait))

                    FirestoreClass().uploadImageToCloudStorage(
                        this@UserProfileActivity,
                        mSelectedImageFileUri
                    )
                    if(validateUserProfileDetails()){

                        showProgressDialog(resources.getString(R.string.please_wait))

                        FirestoreClass().uploadImageToCloudStorage(
                            this@UserProfileActivity,
                            mSelectedImageFileUri
                        )

                    }else{

                        updateUserProfileDetails()
                    }


                }
            }
        }
    }

    private fun validateUserProfileDetails(): Boolean {
        return when {

            TextUtils.isEmpty(phoneTextField.text.toString().trim { it <= ' ' }) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_mobile_number), true)
                false
            }
            else -> {
                true
            }
        }
    }

    fun userProfileUpdateSuccess(){

        hideProgressDialog()

        Toast.makeText(
            this@UserProfileActivity,
            resources.getString(R.string.msg_profile_update_success),
            Toast.LENGTH_SHORT
        ).show()

        startActivity(Intent(this@UserProfileActivity, MainActivity::class.java))
        finish()
    }

    fun imageUploadSuccess(imageURL: String) {

        // Hide the progress dialog


        mUserProfileImageURL = imageURL

        updateUserProfileDetails()
    }

    private fun updateUserProfileDetails(){
        val userHashMap = HashMap<String, Any>()


        val mobileNumber = phoneTextField.text.toString().trim{ it <= ' '}

        val gender = if(rb_male.isChecked){
            Constants.MALE
        }else{
            Constants.FEMALE
        }


        if (mUserProfileImageURL.isNotEmpty()){
            userHashMap[Constants.IMAGE] = mUserProfileImageURL
        }

        if(mobileNumber.isNotEmpty()){
            userHashMap[Constants.MOBILE] = mobileNumber.toLong()
        }

        userHashMap[Constants.GENDER] = gender

        userHashMap[Constants.COMPLETE_PROFILE] = 1

        FirestoreClass().updateUserProfileData(
            this@UserProfileActivity,
            userHashMap
        )


    }
}