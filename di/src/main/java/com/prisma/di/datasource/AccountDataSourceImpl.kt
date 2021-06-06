package com.prisma.di.datasource

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.prisma.data.remote.AccountDataSource
import com.prisma.data.local.model.BCBackendModel
import com.prisma.data.na.backend.model.ResultWrapper
import com.prisma.data.remote.repository.BCGetAccountRepository
import com.prisma.di.AccountUIModelMapperImpl
import com.prisma.di.ErrorUIModelMapperImpl
import com.prisma.domain.model.BCUIModel
import com.prisma.domain.model.UseCaseResult

class AccountDataSourceImpl(
    private val repository: BCGetAccountRepository,
    private val responseMapper: AccountUIModelMapperImpl,
    private val errorMappper: ErrorUIModelMapperImpl
) : AccountDataSource {
    override suspend fun getAccount(context: Context): LiveData<UseCaseResult<BCUIModel.AccountModel>> {

        return MediatorLiveData<UseCaseResult<BCUIModel.AccountModel>>().apply {

            val result = repository.fetchData(true,null).value as ResultWrapper<BCBackendModel.BCAccountModel>
            this.value = UseCaseResult(
                result.status,
                responseMapper.fromBackendModelToUIModel(result.result),
                errorMappper.fromBackendModelToUIModel(result.error)
            )
        }
    }
}