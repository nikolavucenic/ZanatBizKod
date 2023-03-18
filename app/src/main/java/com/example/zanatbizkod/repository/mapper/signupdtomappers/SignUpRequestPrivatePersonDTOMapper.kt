package com.example.zanatbizkod.repository.mapper.signupdtomappers

import com.example.zanatbizkod.dtomappers.DomainMapper
import com.example.zanatbizkod.model.signup.SignUpRequestPrivatePerson
import com.example.zanatbizkod.model.signupdtos.SignUpRequestPrivatePersonDTO

class SignUpRequestPrivatePersonDTOMapper :
    DomainMapper<SignUpRequestPrivatePerson, SignUpRequestPrivatePersonDTO> {
    override fun mapEntity(model: SignUpRequestPrivatePerson?): SignUpRequestPrivatePersonDTO =
        SignUpRequestPrivatePersonDTO(
            email = requireNotNull(model?.email) { "The email field cannot be null" },
            password = requireNotNull(model?.password) { "The password field cannot be null" },
            phoneNumber = requireNotNull(model?.phoneNumber) { "The phone number field cannot be null" },
            firstName = requireNotNull(model?.firstName) { "The first name field cannot be null" },
            lastName = requireNotNull(model?.lastName) { "The last name field cannot be null" },
        )
}