package com.prisma.di

interface ItemUIModelMapper<BCBackendModel, BCCacheModel, BCUIModel> {

    fun fromBackendModelToUIModel(origin: BCBackendModel): BCUIModel

    fun fromCacheModelToUIModel(origin: BCCacheModel): BCUIModel
}