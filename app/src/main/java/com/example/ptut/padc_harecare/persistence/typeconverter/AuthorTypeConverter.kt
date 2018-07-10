package com.example.ptut.padc_harecare.persistence.typeconverter

import android.arch.persistence.room.TypeConverter
import com.example.ptut.padc_harecare.persistence.entities.Author
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*
import java.util.Collections.emptyList


class AuthorTypeConverter {
    var gson = Gson()

    @TypeConverter
    fun stringToSomeObjectList(data: String?): Author {
        val listType = object : TypeToken<Author>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun someObjectListToString(someObjects: Author): String {
        return gson.toJson(someObjects)
    }
}