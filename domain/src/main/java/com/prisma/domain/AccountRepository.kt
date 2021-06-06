package com.prisma.domain

import android.content.Context
import androidx.lifecycle.LiveData
import com.prisma.domain.model.BCUIModel
import com.prisma.domain.model.UseCaseResult

interface AccountRepository {
    suspend fun getAccount(context: Context): LiveData<UseCaseResult<BCUIModel.AccountModel>>
}