package com.example.etrite

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.etrite.firestore.FirestoreClass
import com.example.etrite.models.User
import com.example.etrite.utils.Constants
import com.example.etrite.utils.GlideLoader
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_user_profile.*
import kotlinx.android.synthetic.main.fragment_profile.*
import java.io.IOException

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

        usernameTextField.isEnabled = false
        usernameTextField.setText(muserDetails.username)


        userprofilePicture.setOnClickListener(this@UserProfileActivity)
        completeProfileBtn.setOnClickListener(this@UserProfileActivity)
    }

    override fun onClick(v: View?){
        if (v!=null){
            when(v.id){
                R.id.userprofilePicture ->{
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



//                        val userHashMap = HashMap<String, Any>()
//
//
//                        val mobileNumber = et_mobile_number.text.toString().trim{ it <= ' '}
//
//                        val gender = if(rb_male.isChecked){
//                            Constants.MALE
//                        }else{
//                            Constants.FEMALE
//                        }
//
//                        if(mobileNumber.isNotEmpty()){
//                            userHashMap[Constants.MOBILE] = mobileNumber.toLong()
//                        }
//
//                        userHashMap[Constants.GENDER] = gender
//
//                        showProgressDialog(resources.getString(R.string.please_wait))
//
//                        FirestoreClass().updateUserProfileData(
//                                this@UserProfileActivity,
//                                userHashMap
//                        )

                }
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == Constants.READ_STORAGE_PERMISSION_CODE) {
            //If permission is granted
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                Constants.showImageChooser(this@UserProfileActivity)
            } else {
                //Displaying another toast if permission is not granted
                Toast.makeText(
                    this,
                    resources.getString(R.string.read_storage_permission_denied),
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK){
            if(requestCode == Constants.PICK_IMAGE_REQUEST_CODE){
                if(data!=null){
                    try {

                        mSelectedImageFileUri = data.data!!

                        GlideLoader(this@UserProfileActivity).loadUserPicture(
                            mSelectedImageFileUri!!,
                            userprofilePicture
                        )
                    } catch (e: IOException){
                        e.printStackTrace()
                        Toast.makeText(
                            this@UserProfileActivity,
                            resources.getString(R.string.image_selection_failed),
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }
                }else if (resultCode == Activity.RESULT_CANCELED) {
                    // A log is printed when user close or cancel the image selection.
                    Log.e("Request Cancelled", "Image selection cancelled")
                }
            }
        }
    }

    private fun validateUserProfileDetails(): Boolean {
        return when {

            // We have kept the user profile picture is optional.
            // The FirstName, LastName, and Email Id are not editable when they come from the login screen.
            // The Radio button for Gender always has the default selected value.

            // Check if the mobile number is not empty as it is mandatory to enter.
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

        startActivity(Intent(this@UserProfileActivity, Dashboard::class.java))
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