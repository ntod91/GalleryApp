package com.typeqast.core.ui.activites

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.typeqast.core.ui.ICoreView

abstract class CoreActivity<VDB : ViewDataBinding, VM : ViewModel> : AppCompatActivity(),
    ICoreView {
    private lateinit var binding: VDB
    private lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialize()
    }

    private fun initialize() {
        setupViewModel()
        setupDataBinding()
    }

    /**
     * DataBinding setup
     */
    private fun setupDataBinding() {
        binding = DataBindingUtil.setContentView(this, provideLayout())
        binding.apply {
            lifecycleOwner = this@CoreActivity
            setVariable(provideBindingId(), viewModel)
        }
    }

    /**
     *  ViewModel setup
     */
    private fun setupViewModel() {
        viewModel = ViewModelProvider
            .AndroidViewModelFactory
            .getInstance(application)
            .create(provideViewModel())
    }

    /**
     * Returns viewModel object
     */
    fun getViewModel() = viewModel

    /**
     * Returns DataBinding object
     */
    fun getBinding() = binding

    /**
     * Provide ViewModel class
     * @sample "HomeScreenViewModel::class.java"
     */
    abstract fun provideViewModel(): Class<VM>

    /**
     * Provide layout file
     * @sample "R.id.activity_home_screen"
     */
    abstract fun provideLayout(): Int
}