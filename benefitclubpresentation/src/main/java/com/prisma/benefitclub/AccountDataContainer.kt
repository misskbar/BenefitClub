package com.prisma.benefitclub

import com.prisma.core.base.data_containers.BaseUIDataContainer
import com.prisma.core.base.state.State
import com.prisma.domain.model.BCUIModel

class AccountDataContainer: BaseUIDataContainer<AccountDataContainer> {

    lateinit var response: BCUIModel.AccountModel

    constructor(state: State) : super(state)

    constructor(state: State, response: BCUIModel.AccountModel) : super(state) {
        this.response = response
    }
}