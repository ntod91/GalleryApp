package com.typeqast.galleryapp

import android.app.Application
import com.typeqast.core.utils.Cashing


class GalleryApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        Cashing.initialize(this,getString(R.string.app_name))
    }
}