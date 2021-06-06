package com.prisma.data.local.di

import android.content.Context
import com.prisma.data.na.utils.EmptyInterceptor
import okhttp3.Interceptor
import org.koin.core.scope.Scope

//val URL_BASE = StringQualifier("URL_BASE")
//
//val bcBaseUrlModule = module {
//    factory{ BCRoomDatabase.getInstance(get()) }
//    factory(URL_BASE) { get<Application>().resources.getString(R.string.URL_BASE) }
//}
//
//val bcEndPointsModule = module {
//    factory<BCGetProfileServiceApi> {
//        RestClientCore(getRestClientParams(get(URL_BASE))).retrofitClient.create(
//            BCGetProfileServiceApi::class.java
//        )
//    }
//}
//
//val bcAccountModule = module {
////    factory { AccountUIModelMapperImpl() }
////    factory { ErrorUIModelMapperImpl() }
//    factory { BCAccountModelMapper() }
//
//    factory{ BCGetAccountRepository(get(), get(), get(), get(), get()) }
//
////    factory<AccountUseCase>(override = true) { AccountDataWrapper(get(), get(), get()) }
//
//}

//fun Scope.getRestClientParams(baseUrl: String): Triple<Context, String, Interceptor> =
//    Triple(get(), baseUrl, EmptyInterceptor())
