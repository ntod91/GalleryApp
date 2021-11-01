package com.typeqast.galleryapp.homescreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.typeqast.domain.models.GalleryEntity
import com.typeqast.domain.wrappers.Resource


class HomeScreenViewModel : ViewModel() {
   val galleryImages : LiveData<Resource<List<GalleryEntity>>> = liveData {
       emitSource(HomeScreenInjector.provideGalleryUseCase().execute())
   }
}