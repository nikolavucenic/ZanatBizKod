package com.example.zanatbizkod.repository.loginrepository

import android.content.Context
import android.util.Log
import android.view.View
import com.example.zanatbizkod.model.login.LoginRequest
import com.example.zanatbizkod.repository.mapper.logindtomapper.LoginRequestDTOMapper
import com.example.zanatbizkod.repository.mapper.logindtomapper.LoginResponseDTOMapper
import com.example.zanatbizkod.repository.service.SigningService

class LoginRepositoryImpl(
    private val loginRequestDTOMapper: LoginRequestDTOMapper,
) : LoginRepository {

    override suspend fun passLoginInformation(loginRequest: LoginRequest): Boolean? =
        loginRequest.runCatching {
            loginRequestDTOMapper.mapEntity(this)
        }.mapCatching {
            SigningService.login(loginRequest)
        }.onFailure {
            Log.e("Login Error", "passLoginInformation error: ${it.message}")
        }.getOrNull()

}