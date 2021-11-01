package com.typeqast.galleryapp.homescreen

import android.os.Bundle
import com.typeqast.core.ui.ICoreView
import com.typeqast.domain.models.GalleryEntity
import com.typeqast.galleryapp.R
import com.typeqast.galleryapp.databinding.ActicityHomeScreenBinding
import com.typeqast.galleryapp.utils.BaseActivity
import com.typeqast.galleryapp.utils.ResponseWrapper


class HomeScreenActivity : BaseActivity<ActicityHomeScreenBinding, HomeScreenViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getViewModel()
            .galleryImages
            .observe(
                this,
                object : ResponseWrapper<List<GalleryEntity>, ICoreView>(this) {
                    override fun onSuccess(data: List<GalleryEntity>?) {
                    }
                }
            )
    }

    override fun provideTAG(): String {
        return HomeScreenActivity::class.java.simpleName
    }

    override fun provideViewModel(): Class<HomeScreenViewModel> {
        return HomeScreenViewModel::class.java
    }

    override fun provideLayout(): Int {
        return R.layout.acticity_home_screen
    }
}