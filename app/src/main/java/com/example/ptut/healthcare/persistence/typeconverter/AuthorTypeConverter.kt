package com.example.ptut.healthcare.persistence.typeconverter

import android.arch.persistence.room.TypeConverter
import com.example.ptut.healthcare.persistence.entities.Author
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken



class AuthorTypeConverter {
    private var gson = Gson()

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