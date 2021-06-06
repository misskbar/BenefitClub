package com.prisma.di

import android.app.Application
import android.content.Context
import com.prisma.data.R
import com.prisma.data.local.cache.database.BCRoomDatabase
import com.prisma.data.local.cache.model.BCCacheModel
import com.prisma.data.local.mapper.BCAccountModelMapper
import com.prisma.data.local.model.BCBackendModel
import com.prisma.data.na.backend.rest_client.RestClientCore
import com.prisma.data.na.mapper.ItemModelMapper
import com.prisma.data.na.utils.EmptyInterceptor
import com.prisma.data.remote.AccountDataSource
import com.prisma.data.remote.api.BCGetProfileServiceApi
import com.prisma.data.remote.repository.AccountRepositoryImpl
import com.prisma.data.remote.repository.BCGetAccountRepository
import com.prisma.di.datasource.AccountDataSourceImpl
import com.prisma.domain.AccountRepository
import com.prisma.domain.AccountUseCase
import okhttp3.Interceptor
import org.koin.core.qualifier.StringQualifier
import org.koin.core.scope.Scope
import org.koin.dsl.module

val URL_BASE = StringQualifier("URL_BASE")

val bcBaseUrlModule = module {
    factory { BCRoomDatabase.getInstance(get()) }
    factory(URL_BASE) { get<Application>().resources.getString(R.string.URL_BASE) }
}

val bcEndPointsModule = module {
    factory<BCGetProfileServiceApi> {
        RestClientCore(getRestClientParams(get(URL_BASE))).retrofitClient.create(
            BCGetProfileServiceApi::class.java
        )
    }
}

val bcDIModule = module {
    factory { AccountUIModelMapperImpl() }
    factory { ErrorUIModelMapperImpl() }
    factory { BCAccountModelMapper() }
    factory { AccountUseCase(get()) }

}

val bcDataModule = module {
    single<ItemModelMapper<BCBackendModel.BCAccountModel, BCCacheModel.BCAccountModel>>(override = true) { BCAccountModelMapper() }
    factory { BCGetAccountRepository(get(), get(), get(), get(), get()) }
    factory<AccountRepository>(override = true) { AccountRepositoryImpl(get()) }
    factory<AccountDataSource>(override = true) { AccountDataSourceImpl(get(), get(), get()) }
}

fun Scope.getRestClientParams(baseUrl: String): Triple<Context, String, Interceptor> =
    Triple(get(), baseUrl, EmptyInterceptor())

