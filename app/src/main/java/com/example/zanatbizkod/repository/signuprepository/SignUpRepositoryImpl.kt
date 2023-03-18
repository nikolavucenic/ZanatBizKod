package com.example.zanatbizkod.repository.signuprepository

import android.util.Log
import com.example.zanatbizkod.model.signup.SignUpRequestLegalEntity
import com.example.zanatbizkod.model.signup.SignUpRequestPrivatePerson
import com.example.zanatbizkod.repository.mapper.signupdtomappers.SignUpRequestLegalEntityDTOMapper
import com.example.zanatbizkod.repository.mapper.signupdtomappers.SignUpRequestPrivatePersonDTOMapper
import com.example.zanatbizkod.repository.service.SigningService

class SignUpRepositoryImpl(
    private val signUpRequestPrivatePersonDTOMapper: SignUpRequestPrivatePersonDTOMapper,
    private val signUpRequestLegalEntityDTOMapper: SignUpRequestLegalEntityDTOMapper,
) : SignUpRepository {

    override suspend fun passSignUpInformationPrivatePerson(signUpRequestPrivatePerson: SignUpRequestPrivatePerson): Boolean? =
        signUpRequestPrivatePerson.runCatching {
            signUpRequestPrivatePersonDTOMapper.mapEntity(this)
        }.mapCatching {
            SigningService.signUpPrivatePerson(it)
        }.onFailure {
            Log.e("Error","SignUpRequestPrivatePerson error: ${it.message}")
        }.getOrNull()

    override suspend fun passSignUpInformationLegalEntity(signUpRequestLegalEntity: SignUpRequestLegalEntity): Boolean? =
        signUpRequestLegalEntity.runCatching {
            signUpRequestLegalEntityDTOMapper.mapEntity(this)
        }.mapCatching {
            SigningService.signUpLegalEntity(it)
        }.onFailure {
            Log.e("Error","SignUpRequestLegalEntity error: ${it.message}")
        }.getOrNull()

}