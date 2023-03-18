package com.example.zanatbizkod.model.login

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("username")
    val username: String,
    @SerializedName("password")
    val password: String,
    //@SerializedName("grant_type")
    //val grant_type: String = Consts.PASSWORD,
)

