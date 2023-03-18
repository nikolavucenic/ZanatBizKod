package com.example.zanatbizkod.dtomappers

interface SuspendDomainMapper<T, DomainModel> {

    suspend fun mapEntity(model: T?): DomainModel

}