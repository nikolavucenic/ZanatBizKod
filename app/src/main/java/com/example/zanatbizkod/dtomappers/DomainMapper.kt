package com.example.zanatbizkod.dtomappers

interface DomainMapper<T, DomainModel> {

    fun mapEntity(model: T?): DomainModel

}