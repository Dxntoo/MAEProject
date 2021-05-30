package com.example.etrite.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * A data model class for Product with required fields.
 * parcelize allow us to do serialization and deserialization of data
 */
@Parcelize
data class Exercise(
    val user_id: String = "",
    val user_name: String = "",
    val title: String = "",
    val price: String = "",
    val description: String = "",
    val image: String = "",
    var product_id: String = "",
) : Parcelable