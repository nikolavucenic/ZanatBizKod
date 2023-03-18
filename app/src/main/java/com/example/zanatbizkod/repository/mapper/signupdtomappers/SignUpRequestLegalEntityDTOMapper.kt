package com.example.zanatbizkod.repository.mapper.signupdtomappers

import com.example.zanatbizkod.dtomappers.DomainMapper
import com.example.zanatbizkod.model.signup.SignUpRequestLegalEntity
import com.example.zanatbizkod.model.signupdtos.SignUpRequestLegalEntityDTO

class SignUpRequestLegalEntityDTOMapper :
    DomainMapper<SignUpRequestLegalEntity, SignUpRequestLegalEntityDTO> {
    override fun mapEntity(model: SignUpRequestLegalEntity?): SignUpRequestLegalEntityDTO =
        SignUpRequestLegalEntityDTO(
            name = requireNotNull(model?.name) { "The name field cannot be null" },
            pib = requireNotNull(model?.pib) { "The pib field cannot be null" },
            companyNumber = requireNotNull(model?.companyNumber) { "The company number field cannot be null" },
            phoneNumber = requireNotNull(model?.phoneNumber) { "The phone number field cannot be null" },
            email = requireNotNull(model?.email) { "The email field cannot be null" },
        )
}