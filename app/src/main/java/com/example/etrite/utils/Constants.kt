package com.example.etrite.utils

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import android.webkit.MimeTypeMap

object Constants {
    const val USERS: String = "users"
    const val ETRITE_PREFERENCES: String = "eTritePrefs"
    const val LOGGED_IN_USERNAME: String = "logged_in_username"

    const val EXTRA_USER_DETAILS: String = "extra_user_details"

    const val READ_STORAGE_PERMISSION_CODE = 2

    const val PICK_IMAGE_REQUEST_CODE = 2

    const val MALE: String = "Male"

    const val FEMALE: String = "Female"

    const val MOBILE: String = "mobile"

    const val GENDER: String = "gender"

    const val USERNAME: String = "username"

    const val USER_PROFILE_IMAGE = "User_Profile_Image"

    const val IMAGE: String = "image"

    const val COMPLETE_PROFILE: String = "profileCompleted"

    fun showImageChooser(activity: Activity) {
        val galleryIntent = Intent(
            Intent.ACTION_PICK,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        )
        activity.startActivityForResult(galleryIntent, PICK_IMAGE_REQUEST_CODE)
    }


    fun getFileExtension(activity: Activity, uri: Uri?): String? {
        return MimeTypeMap.getSingleton()
            .getExtensionFromMimeType(activity.contentResolver.getType(uri!!))
    }
}