package com.prisma.benefitclub

import android.app.Application
import com.prisma.core.di.coreModule
import com.prisma.di.bcBaseUrlModule
import com.prisma.di.bcDIModule
import com.prisma.di.bcDataModule
import com.prisma.di.bcEndPointsModule
import org.koin.android.java.KoinAndroidApplication.create
import org.koin.core.context.GlobalContext
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.core.module.Module

//class TestApplication : Application() {
//
//    override fun onCreate() {
//        super.onCreate()
//
//        val modules: ArrayList<Module> =  arrayListOf()
//        modules.addAll(
//            listOf(
//                coreModule,
//                bcBaseUrlModule,
//                bcEndPointsModule,
//                bcDIModule,
//                bcDataModule,
//                bcViewModelModule
//            )
//        )
//
//        val koinApplication = create(this, Level.INFO).modules(modules)
//
//        startKoin(GlobalContext, koinApplication)
//    }
//
//}