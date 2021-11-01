package com.typeqast.data.repositories

import com.typeqast.data.remote.NetworkModule
import com.typeqast.data.remote.models.GalleryEntityApi
import com.typeqast.domain.mappers.DomainMapping
import com.typeqast.domain.models.GalleryEntity
import com.typeqast.domain.repositores.GalleryRepository

class GalleryRepositoryImpl(
    private val networkModule: NetworkModule,
    private val domainMapper: DomainMapping<List<GalleryEntity>, List<GalleryEntityApi>>
) : GalleryRepository {
    override suspend fun fetchAllImages(): List<GalleryEntity> {
        return try {
            val allGalleryImages = networkModule.remote.getAllGalleryImages()
            domainMapper.mapToDomain(allGalleryImages.items)
        } catch (error: Exception) {
            throw (error)
        }
    }
}