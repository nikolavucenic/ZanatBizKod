package com.example.zanatbizkod.model.api

import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("Status")
    val status: Boolean,
    @SerializedName("Message")
    val message: String,
)
