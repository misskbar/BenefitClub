package com.prisma.data.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.prisma.data.cache.BC_ACCOUNT_TABLE_NAME
import com.prisma.data.cache.model.BCCacheModel
import com.prisma.data.na.cache.dao.CacheItemDao

@Dao
interface BCAccountDao: CacheItemDao<BCCacheModel.BCAccountModel> {

    @Query("DELETE FROM $BC_ACCOUNT_TABLE_NAME")
    override suspend fun delete()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    override suspend fun insert(model: BCCacheModel.BCAccountModel)

    @Query("SELECT * FROM $BC_ACCOUNT_TABLE_NAME")
    override fun fetch(): BCCacheModel.BCAccountModel

    @Query("SELECT * FROM $BC_ACCOUNT_TABLE_NAME")
    suspend fun suspendFetch(): BCCacheModel.BCAccountModel
}