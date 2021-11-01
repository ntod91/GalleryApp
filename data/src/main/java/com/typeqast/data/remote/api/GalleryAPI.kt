package com.typeqast.data.remote.api

import com.typeqast.data.remote.models.Wrapper
import retrofit2.http.GET

interface GalleryAPI {
    @GET("079deb9d-97ae-4106-898a-8c60bde5cd11")
    suspend fun getAllGalleryImages(): Wrapper
}