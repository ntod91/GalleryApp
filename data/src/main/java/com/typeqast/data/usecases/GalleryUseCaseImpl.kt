package com.typeqast.data.usecases

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.typeqast.domain.models.GalleryEntity
import com.typeqast.domain.repositores.GalleryRepository
import com.typeqast.domain.usecases.GalleryUseCase
import com.typeqast.domain.wrappers.Resource

class GalleryUseCaseImpl(private val galleryRepository: GalleryRepository) : GalleryUseCase {
    override suspend fun execute(): LiveData<Resource<List<GalleryEntity>>> {
        return liveData {
            try {
                emit(Resource.loading<List<GalleryEntity>>())
                emit(Resource.success(galleryRepository.fetchAllImages(), null))
            } catch (error: Error) {
                emit(Resource.error(null, error))
            }
        }
    }
}