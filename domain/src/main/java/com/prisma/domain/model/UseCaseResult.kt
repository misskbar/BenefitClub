package com.prisma.domain.model

class UseCaseResult<BUIModelType> constructor(val status: String, val result: BUIModelType, val error: BCUIModel.ErrorModel)