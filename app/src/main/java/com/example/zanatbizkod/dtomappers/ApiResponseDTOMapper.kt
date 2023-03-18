package com.example.zanatbizkod.dtomappers

import com.example.zanatbizkod.model.api.ApiResponse
import com.example.zanatbizkod.model.api.ApiResponseDTO

class ApiResponseDTOMapper : DomainMapper<ApiResponse, ApiResponseDTO> {
    override fun mapEntity(model: ApiResponse?): ApiResponseDTO =
        ApiResponseDTO(
            status = requireNotNull(model?.status),
            message = requireNotNull(model?.message),
        )
}