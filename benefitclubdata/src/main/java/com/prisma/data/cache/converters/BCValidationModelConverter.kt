package com.prisma.data.cache.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.prisma.data.na.cache.model.CacheModel
import java.util.*

class BCValidationModelConverter {
    var gson = Gson()

    @TypeConverter
    fun stringToList(data: String?): List<CacheModel.ValidationModel>? {

        if (data == null){
            return Collections.emptyList()
        }

        val listType = object : TypeToken<ArrayList<CacheModel.ValidationModel>>() {}.type

        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun listToString(someObjects: List<CacheModel.ValidationModel>?): String? {

        return gson.toJson(someObjects)
    }
}