package com.example.ptut.healthcare.persistence.entities

import android.arch.persistence.room.*
import com.example.ptut.healthcare.persistence.typeconverter.AuthorTypeConverter
import com.google.gson.annotations.SerializedName

@Entity(tableName = "healthInfo")
open class HealthcareInfoItem(@PrimaryKey var id: Int = 0,
                              var image: String? = null,
                              @ColumnInfo(name = "complete-url")
                              @SerializedName("complete-url") var completeUrl: String? = null,
                              var title: String? = null,
                              @ColumnInfo(name = "published-date")
                              @SerializedName("published-date") var publishedDate: String? = null,
                              @ColumnInfo(name = "short-description")
                              @SerializedName("short-description")
                              var shortDescription: String? = null,
                              @Embedded
                              var author: Author? = null) {
}