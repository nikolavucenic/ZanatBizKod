package com.example.zanatbizkod.repository.mapper.logindtomapper

import com.example.zanatbizkod.dtomappers.DomainMapper
import com.example.zanatbizkod.model.dto.LoginRequestDTO
import com.example.zanatbizkod.model.login.LoginRequest

class LoginRequestDTOMapper : DomainMapper<LoginRequest, LoginRequestDTO> {
    override fun mapEntity(model: LoginRequest?): LoginRequestDTO =
        LoginRequestDTO(
            username = requireNotNull(model?.username) { "The username field cannot be null" },
            password = requireNotNull(model?.password) { "The password field cannot be null" },
            grantType = ""//requireNotNull(model?.grant_type) { "The grant type field cannot be null" },
        )
}