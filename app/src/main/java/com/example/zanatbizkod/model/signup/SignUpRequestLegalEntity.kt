package com.example.zanatbizkod.model.signup

import com.google.gson.annotations.SerializedName

data class SignUpRequestLegalEntity(
    @SerializedName("name")
    val name: String,
    @SerializedName("tin")
    val pib: String,
    @SerializedName("companynumber")
    val companyNumber: String,
    @SerializedName("phonenumber")
    val phoneNumber: String,
    @SerializedName("email")
    val email: String,
)