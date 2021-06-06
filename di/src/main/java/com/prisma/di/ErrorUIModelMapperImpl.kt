package com.prisma.di

import com.prisma.data.na.backend.model.BackendModel
import com.prisma.domain.model.BCUIModel

class ErrorUIModelMapperImpl : ErrorUIModelMapper<BackendModel.ErrorModel, BCUIModel.ErrorModel>{
    override fun fromBackendModelToUIModel(origin: BackendModel.ErrorModel): BCUIModel.ErrorModel {
        return BCUIModel.ErrorModel(origin.http_code, origin.error, origin.error_description)
    }
}