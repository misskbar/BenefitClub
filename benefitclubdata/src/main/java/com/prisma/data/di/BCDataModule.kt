package com.prisma.data.di

import android.app.Application
import android.content.Context
import com.prisma.data.R
import com.prisma.data.api.BCGetProfileServiceApi
import com.prisma.data.na.backend.rest_client.RestClientCore
import com.prisma.data.na.utils.EmptyInterceptor
import com.prisma.data.repository.BCGetAccountRepository
import okhttp3.Interceptor
import org.koin.core.qualifier.StringQualifier
import org.koin.core.scope.Scope
import org.koin.dsl.module

val URL_BASE = StringQualifier("URL_BASE")

val bcBaseUrlModule = module {
    factory(URL_BASE) { get<Application>().resources.getString(R.string.URL_BASE) }
}

val bcEndPointsModule = module {
    factory<BCGetProfileServiceApi> {
        RestClientCore(getRestClientParams(get(URL_BASE))).retrofitClient.create(
            BCGetProfileServiceApi::class.java
        )
    }
}

val bcAccountModule = module {
    factory { BCGetAccountRepository(get(), get(), get(), get(), get()) }

}

fun Scope.getRestClientParams(baseUrl: String): Triple<Context, String, Interceptor> =
    Triple(get(), baseUrl, EmptyInterceptor())
