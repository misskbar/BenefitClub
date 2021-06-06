package com.prisma.data.remote.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.prisma.data.remote.AccountDataSource
import com.prisma.domain.AccountRepository
import com.prisma.domain.model.BCUIModel
import com.prisma.domain.model.UseCaseResult

class AccountRepositoryImpl( private val dataSource: AccountDataSource) :AccountRepository{
    override suspend fun getAccount(context: Context): LiveData<UseCaseResult<BCUIModel.AccountModel>> {
      return dataSource.getAccount(context)
    }
}