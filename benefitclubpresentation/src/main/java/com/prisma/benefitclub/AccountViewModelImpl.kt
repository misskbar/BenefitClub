package com.prisma.benefitclub

import android.app.Application
import android.content.Context
import androidx.lifecycle.MediatorLiveData
import com.prisma.core.base.state.DefaultState
import com.prisma.domain.AccountUseCase
import com.prisma.domain.model.BCUIModel
import com.prisma.domain.model.BCUIModel.BackendCallStatus.Companion.FAIL
import com.prisma.domain.model.BCUIModel.BackendCallStatus.Companion.OK
import com.prisma.domain.model.BCUIModel.BackendError.Companion.NO_NETWORK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AccountViewModelImpl(application: Application,
                           private val dataManager: AccountUseCase
) : AccountViewModel(application){

    private val mediator = MediatorLiveData<AccountDataContainer>()

    override fun getMediator(): MediatorLiveData<AccountDataContainer> {
        return mediator
    }

    override fun getUser(context: Context) {

        mediator.value = AccountDataContainer(DefaultState.LOADING)

        //Start Coroutine
        GlobalScope.launch(Dispatchers.Main) {

            //Call Repository
            val result = dataManager.getAccountData(context)

            //Li
            mediator.addSource(result) { liveData ->

                when (liveData.status) {

                    OK -> showResult(liveData.result)

                    FAIL -> showError(liveData.error)
                }
            }
        }

    }

    private fun showResult(model: BCUIModel.AccountModel) {
        mediator.value = AccountDataContainer(DefaultState.SUCCESS, model)
    }

    private fun showError(error: BCUIModel.ErrorModel?) {
        mediator.value = if (NO_NETWORK == error?.error) {
            AccountDataContainer(DefaultState.NO_NETWORK)
        } else {
            AccountDataContainer(DefaultState.ERROR)
        }
    }
}