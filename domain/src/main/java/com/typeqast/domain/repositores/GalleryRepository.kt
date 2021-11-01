package com.typeqast.domain.repositores

import com.typeqast.domain.models.GalleryEntity


interface GalleryRepository {
    suspend fun fetchAllImages(): List<GalleryEntity>
}