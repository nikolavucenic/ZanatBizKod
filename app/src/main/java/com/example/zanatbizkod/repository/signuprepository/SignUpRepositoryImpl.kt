package com.example.zanatbizkod.repository.signuprepository

import android.util.Log
import com.example.zanatbizkod.dtomappers.ApiResponseDTOMapper
import com.example.zanatbizkod.model.api.ApiResponseDTO
import com.example.zanatbizkod.model.signup.SignUpRequestLegalEntity
import com.example.zanatbizkod.model.signup.SignUpRequestPrivatePerson
import com.example.zanatbizkod.repository.mapper.signupdtomappers.SignUpRequestLegalEntityDTOMapper
import com.example.zanatbizkod.repository.mapper.signupdtomappers.SignUpRequestPrivatePersonDTOMapper
import com.example.zanatbizkod.repository.service.SigningService

class SignUpRepositoryImpl(
    private val api: SigningService,
    private val signUpRequestPrivatePersonDTOMapper: SignUpRequestPrivatePersonDTOMapper,
    private val signUpRequestLegalEntityDTOMapper: SignUpRequestLegalEntityDTOMapper,
    private val apiResponseDTOMapper: ApiResponseDTOMapper
) : SignUpRepository {

    override suspend fun passSignUpInformationPrivatePerson(signUpRequestPrivatePerson: SignUpRequestPrivatePerson): ApiResponseDTO? = null
        /*signUpRequestPrivatePerson.runCatching {
            signUpRequestPrivatePersonDTOMapper.mapEntity(this)
        }.mapCatching {
            api.signUpPrivatePerson(
                it.email,
                it.password,
                it.phoneNumber,
                it.firstName,
                it.lastName,
            ).body()
        }.mapCatching {
            apiResponseDTOMapper.mapEntity(it)
        }.onFailure {
            Log.e("Error","SignUpRequestPrivatePerson error: ${it.message}")
        }.getOrNull()*/

    override suspend fun passSignUpInformationLegalEntity(signUpRequestLegalEntity: SignUpRequestLegalEntity): ApiResponseDTO? = null
        /*signUpRequestLegalEntity.runCatching {
            signUpRequestLegalEntityDTOMapper.mapEntity(this)
        }.mapCatching {
            api.signUpLegalEntity(
                it.name,
                it.pib,
                it.companyNumber,
                it.phoneNumber,
                it.email,
            ).body()
        }.mapCatching {
            apiResponseDTOMapper.mapEntity(it)
        }.onFailure {
            Log.e("Error","SignUpRequestLegalEntity error: ${it.message}")
        }.getOrNull()*/

}