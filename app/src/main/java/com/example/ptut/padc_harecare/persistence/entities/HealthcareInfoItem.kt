package com.example.ptut.padc_harecare.persistence.entities

import android.arch.persistence.room.*
import com.example.ptut.padc_harecare.persistence.typeconverter.AuthorTypeConverter
import com.google.gson.annotations.SerializedName

@Entity(tableName = "healthInfo")
@TypeConverters(AuthorTypeConverter::class)
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
                              var author: Author? = null) {
}