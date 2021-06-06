package com.prisma.data.local.cache.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.prisma.data.local.cache.model.BCCacheModel
import java.util.*

class BCAddressModelConverter {
    var gson = Gson()

    @TypeConverter
    fun stringToList(data: String?): MutableList<BCCacheModel.BCAddressModel>? {

        if (data == null){
            return Collections.emptyList()
        }

        val listType = object : TypeToken<ArrayList<BCCacheModel.BCAddressModel>>() {}.type

        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun listToString(someObjects: MutableList<BCCacheModel.BCAddressModel>?): String? {

        return gson.toJson(someObjects)
    }
}