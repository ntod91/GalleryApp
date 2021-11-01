package com.typeqast.data.remote.models

import com.google.gson.annotations.SerializedName

data class GalleryEntityApi(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("url") val url: String
)