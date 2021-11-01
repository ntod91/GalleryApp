package com.typeqast.domain.usecases

import androidx.lifecycle.LiveData
import com.typeqast.domain.models.GalleryEntity
import com.typeqast.domain.wrappers.Resource

interface GalleryUseCase {
    suspend fun execute(): LiveData<Resource<List<GalleryEntity>>>
}