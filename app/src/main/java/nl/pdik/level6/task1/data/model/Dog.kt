package nl.pdik.level6.task1.data.model

import com.google.gson.annotations.SerializedName

data class Dog(
    @SerializedName("status") val status: String,
    @SerializedName("message") val url: String
)
