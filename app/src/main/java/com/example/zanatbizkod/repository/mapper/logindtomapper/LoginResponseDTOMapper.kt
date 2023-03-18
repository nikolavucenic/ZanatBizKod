package com.example.zanatbizkod.repository.mapper.logindtomapper

import com.example.zanatbizkod.dtomappers.DomainMapper
import com.example.zanatbizkod.model.dto.LoginResponseDTO
import com.example.zanatbizkod.model.login.LoginResponse

class LoginResponseDTOMapper : DomainMapper<LoginResponse, LoginResponseDTO> {
    override fun mapEntity(model: LoginResponse?): LoginResponseDTO =
        LoginResponseDTO(
            accessToken = requireNotNull(model?.accessToken) { "The access token field cannot be null" },
            expiresIn = requireNotNull(model?.expiresIn) { "The expires in field cannot be null" },
        )
}