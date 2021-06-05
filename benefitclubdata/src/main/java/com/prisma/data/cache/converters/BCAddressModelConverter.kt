package com.prisma.data.cache.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.prisma.data.na.cache.model.CacheModel
import java.util.*

class BCAddressModelConverter {
    var gson = Gson()

    @TypeConverter
    fun stringToList(data: String?): MutableList<CacheModel.AddressModel>? {

        if (data == null){
            return Collections.emptyList()
        }

        val listType = object : TypeToken<ArrayList<CacheModel.AddressModel>>() {}.type

        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun listToString(someObjects: MutableList<CacheModel.AddressModel>?): String? {

        return gson.toJson(someObjects)
    }
}