package com.prisma.domain

import android.content.Context
import androidx.lifecycle.LiveData
import com.prisma.domain.model.BCUIModel
import com.prisma.domain.model.UseCaseResult

class AccountUseCase (private val repository: AccountRepository) {

    suspend fun getAccountData(context: Context): LiveData<UseCaseResult<BCUIModel.AccountModel>> {
        return repository.getAccount(context)
    }

}