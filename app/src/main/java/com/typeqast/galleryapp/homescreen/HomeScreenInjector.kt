package com.typeqast.galleryapp.homescreen

import com.typeqast.data.dto.GalleryDTO
import com.typeqast.data.remote.NetworkModule
import com.typeqast.data.remote.models.GalleryEntityApi
import com.typeqast.data.repositories.GalleryRepositoryImpl
import com.typeqast.data.usecases.GalleryUseCaseImpl
import com.typeqast.domain.mappers.DomainMapping
import com.typeqast.domain.models.GalleryEntity
import com.typeqast.domain.usecases.GalleryUseCase

object HomeScreenInjector {
    private val networkModule: NetworkModule = NetworkModule
    private val galleryDTO: DomainMapping<List<GalleryEntity>, List<GalleryEntityApi>> =
        GalleryDTO()
    private val galleryRepository = GalleryRepositoryImpl(networkModule, galleryDTO)
    private val galleryUseCase: GalleryUseCase = GalleryUseCaseImpl(galleryRepository)

    fun provideGalleryUseCase(): GalleryUseCase = galleryUseCase
}