package com.example.zanatbizkod.repository.loginrepository

import com.example.zanatbizkod.model.login.LoginRequest

interface LoginRepository {

    suspend fun passLoginInformation(loginRequest: LoginRequest): Boolean?

}