package com.prisma.data.local.cache.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.prisma.data.local.cache.DATABASE_NAME
import com.prisma.data.local.cache.converters.BCAddressModelConverter
import com.prisma.data.local.cache.converters.BCValidationModelConverter
import com.prisma.data.local.cache.dao.BCAccountDao
import com.prisma.data.local.cache.model.BCCacheModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Database(entities = [
    BCCacheModel.BCAccountModel::class,
    BCCacheModel.BCAddressModel::class,
    BCCacheModel.BCEmailUserModel::class
],
        version = 1,
        exportSchema = false)

@TypeConverters(
        BCAddressModelConverter::class,
        BCValidationModelConverter::class
)

abstract class BCRoomDatabase : RoomDatabase() {

    abstract fun bcAccountDao(): BCAccountDao

    companion object {

        @Volatile
        private var instance: BCRoomDatabase? = null

        @JvmStatic
        fun getInstance(context: Context): BCRoomDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): BCRoomDatabase {
            val roomBuilder = Room.databaseBuilder(context, BCRoomDatabase::class.java, DATABASE_NAME)
            roomBuilder.fallbackToDestructiveMigration()
            return roomBuilder.build()
        }

        @JvmStatic
        fun clean(context: Context) {
            GlobalScope.launch(Dispatchers.IO) {
                getInstance(context).clearAllTables()
            }
        }
    }
}
