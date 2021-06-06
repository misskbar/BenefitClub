package com.prisma.benefitclub


import org.koin.dsl.module
import org.koin.android.viewmodel.dsl.viewModel

val bcViewModelModule = module {
    viewModel<AccountViewModel> { AccountViewModelImpl(get(), get()) }
}