package com.prisma.data.local.cache.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.prisma.data.local.cache.model.BCCacheModel
import java.util.*

class BCValidationModelConverter {
    var gson = Gson()

    @TypeConverter
    fun stringToList(data: String?): List<BCCacheModel.BCValidationModel>? {

        if (data == null){
            return Collections.emptyList()
        }

        val listType = object : TypeToken<ArrayList<BCCacheModel.BCValidationModel>>() {}.type

        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun listToString(someObjects: List<BCCacheModel.BCValidationModel>?): String? {

        return gson.toJson(someObjects)
    }
}