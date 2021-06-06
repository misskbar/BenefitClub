package com.prisma.data.remote.api

import com.prisma.data.local.model.BCBackendModel
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Path

interface BCGetProfileServiceApi {

    @GET("/ms/account/public/oauth/v2/account/{accountId}?expand=user,address")
    suspend fun bcGetUserData(@HeaderMap headers: Map<String, String>,
                            @Path("accountId") accountId: String) : BCBackendModel.BCAccountModel

}