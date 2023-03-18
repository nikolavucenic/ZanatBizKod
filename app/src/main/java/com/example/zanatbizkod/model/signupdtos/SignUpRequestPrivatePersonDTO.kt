package com.example.zanatbizkod.model.signupdtos

data class SignUpRequestPrivatePersonDTO(
    val email: String,
    val password: String,
    val phoneNumber: String,
    val firstName: String,
    val lastName: String,
)