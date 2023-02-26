package nl.pdik.level6.task1.data.model

import com.google.gson.annotations.SerializedName

data class Dog(
    @SerializedName("createdAt") val creationDate: String,
    @SerializedName("url") val urlExtension: String
)
