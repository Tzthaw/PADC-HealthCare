package com.example.ptut.padc_harecare.persistence.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName


class Author(@SerializedName("author-name") var authorName: String? = null,
                  @SerializedName("author-picture") var authorPicture: String? = null,
                  @SerializedName("author-id")
                  var authorId: Int = 0) {
}
