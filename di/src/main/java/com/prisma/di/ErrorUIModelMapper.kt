package com.prisma.di

interface ErrorUIModelMapper<BackendModel, BCUIModel> {
    fun fromBackendModelToUIModel(origin: BackendModel): BCUIModel
}