package com.example.zanatbizkod.repository.signuprepository

import com.example.zanatbizkod.model.api.ApiResponseDTO
import com.example.zanatbizkod.model.signup.SignUpRequestLegalEntity
import com.example.zanatbizkod.model.signup.SignUpRequestPrivatePerson

interface SignUpRepository {

    suspend fun passSignUpInformationPrivatePerson(signUpRequestPrivatePerson: SignUpRequestPrivatePerson): ApiResponseDTO?

    suspend fun passSignUpInformationLegalEntity(signUpRequestLegalEntity: SignUpRequestLegalEntity): ApiResponseDTO?

}