package com.typeqast.data.remote.models

import com.google.gson.annotations.SerializedName

data class Wrapper(@SerializedName("data") val items: List<GalleryEntityApi>)
