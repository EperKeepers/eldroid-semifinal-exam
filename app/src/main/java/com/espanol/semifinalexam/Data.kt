package com.espanol.semifinalexam

import com.google.gson.annotations.SerializedName

data class Data(
    val id: String,
    val name: String,
    val description: String,
    @SerializedName("timestamp") val timestamp: Timestamp
)
