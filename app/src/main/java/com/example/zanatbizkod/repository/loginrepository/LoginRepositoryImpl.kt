package com.example.zanatbizkod.repository.loginrepository

import com.example.zanatbizkod.model.login.LoginRequest
import com.example.zanatbizkod.repository.mapper.logindtomapper.LoginRequestDTOMapper
import com.example.zanatbizkod.repository.mapper.logindtomapper.LoginResponseDTOMapper
import com.example.zanatbizkod.repository.service.SigningService

class LoginRepositoryImpl(
    private val api: SigningService,
    private val loginResponseDTOMapper: LoginResponseDTOMapper,
    private val loginRequestDTOMapper: LoginRequestDTOMapper,
) : LoginRepository {

    override suspend fun passLoginInformation(loginRequest: LoginRequest) {}//: LoginResponseDTO? =

    /*loginRequest.runCatching {
        loginRequestDTOMapper.mapEntity(this)
    }.mapCatching {
        /*api.login(
            it.username,
            it.password,
            it.grantType,
        ).body()*/
    }.mapCatching {
        //loginResponseDTOMapper.mapEntity(it)
    }.onSuccess {
        //it.accessToken.saveToken(it.expiresIn)
    }.onFailure {
        Log.e("Login Error", "passLoginInformation error: ${it.message}")
    }.getOrNull()*/

}