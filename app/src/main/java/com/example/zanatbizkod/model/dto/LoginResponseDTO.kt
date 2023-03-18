package com.example.zanatbizkod.model.dto

data class LoginResponseDTO(
    val accessToken: String,
    val expiresIn: Int,
)