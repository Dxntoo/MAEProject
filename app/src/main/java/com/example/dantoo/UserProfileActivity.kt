package com.example.dantoo

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.dantoo.models.User
import com.example.dantoo.utils.Constants
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.fragment_profile.*

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

        //iv_user_photo.setOnClickListener(this@UserProfileActivity)
        //btn_save.setOnClickListener(this@UserProfileActivity)
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }
}