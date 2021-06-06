package com.prisma.data.remote

import android.content.Context
import androidx.lifecycle.LiveData
import com.prisma.domain.model.BCUIModel
import com.prisma.domain.model.UseCaseResult

interface AccountDataSource {
    suspend fun getAccount(context: Context): LiveData<UseCaseResult<BCUIModel.AccountModel>>
}