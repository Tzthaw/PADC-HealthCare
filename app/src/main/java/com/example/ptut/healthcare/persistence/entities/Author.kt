package com.example.ptut.healthcare.persistence.entities

import com.google.gson.annotations.SerializedName
class Author(@SerializedName("author-name") var authorName: String? = null,
                  @SerializedName("author-picture") var authorPicture: String? = null,
                  @SerializedName("author-id")
                  var authorId: Int = 0) {
}
