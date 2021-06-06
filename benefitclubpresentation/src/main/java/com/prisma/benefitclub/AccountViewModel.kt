package com.prisma.benefitclub

import android.app.Application
import android.content.Context
import androidx.lifecycle.MediatorLiveData
import com.prisma.core.base.viewmodels.BaseViewModel

abstract class AccountViewModel (application: Application) : BaseViewModel(application){
    abstract fun getUser(context: Context)
    abstract fun getMediator(): MediatorLiveData<AccountDataContainer>
}