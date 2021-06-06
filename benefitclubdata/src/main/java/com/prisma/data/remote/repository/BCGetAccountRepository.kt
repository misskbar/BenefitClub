package com.prisma.data.remote.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.prisma.data.remote.api.BCGetProfileServiceApi
import com.prisma.data.local.cache.database.BCRoomDatabase
import com.prisma.data.local.cache.model.BCCacheModel
import com.prisma.data.local.mapper.BCAccountModelMapper
import com.prisma.data.local.model.BCBackendModel
import com.prisma.data.na.backend.model.BackendModel
import com.prisma.data.na.backend.model.ResultWrapper
import com.prisma.data.na.cache.database.AppDatabase
import com.prisma.data.na.repository.BaseNoNetworkRepository
import java.util.*
import java.util.concurrent.TimeUnit

class BCGetAccountRepository  constructor(
    context: Context,
    private val serviceApi: BCGetProfileServiceApi,
    private val mapper: BCAccountModelMapper,
    private val coreDatabase: AppDatabase,
    private val database: BCRoomDatabase
) : BaseNoNetworkRepository<BCBackendModel.BCAccountModel>(context) {

    override suspend fun fetchDataFromBackend(params: HashMap<String, Any>?): Any {

        //Set the Headers
        setHeaders()

//        headers["Authorization"] = "cdc58f85-3f32-46a9-aeb6-71aab2054816"
//        headers["X-tenantId"] = "bimo"

        val accountId = coreDatabase.accountDao().fetch().id
        return serviceApi.bcGetUserData(headers, accountId)
    }

    /**
     * Save the backend data into cache
     */
    override suspend fun saveToCache(backendModel: Any) {

        //Convert Backend into Cache
        val roomModel: BCCacheModel.BCAccountModel =
            mapper.fromBackendModelToCacheModel(backendModel as BCBackendModel.BCAccountModel)

        //Save into Cache
        database.bcAccountDao().delete()
        database.bcAccountDao().insert(roomModel)

    }

    override suspend fun buildResultWrapper(
        retModel: Any?,
        retError: BackendModel.ErrorModel
    ): LiveData<ResultWrapper<BCBackendModel.BCAccountModel>> {

        val status: String = this.getStatus(retModel, retError)

        var retModelFinal = BCBackendModel.BCAccountModel()

        if (retModel != null)
            retModelFinal = retModel as BCBackendModel.BCAccountModel

        liveData.postValue(ResultWrapper(status, retModelFinal, retError))

        return liveData
    }

    override fun fetchDataFromCache(params: HashMap<String, Any>?): Any {
        //Make Cache Fetch
        val roomModel: BCCacheModel.BCAccountModel = database.bcAccountDao().fetch()

        //Convert Cache Entity into Backend Entity
        return mapper.fromCacheModelToBackendModel(roomModel)

    }

    override fun setUpdateInterval(): Long = TimeUnit.MINUTES.toMillis(2)

}