package com.example.zanatbizkod.model.signup

import com.google.gson.annotations.SerializedName

data class SignUpRequestPrivatePerson(
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("phonenumber")
    val phoneNumber: String,
    @SerializedName("firstname")
    val firstName: String,
    @SerializedName("lastname")
    val lastName: String,
)