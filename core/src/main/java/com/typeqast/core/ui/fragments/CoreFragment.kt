package com.typeqast.core.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.typeqast.core.ui.ICoreView

abstract class CoreFragment<VDB : ViewDataBinding, VM : ViewModel> : Fragment(), ICoreView {
    private lateinit var binding: VDB
    private lateinit var viewModel: VM
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initialize(inflater, container)
        return binding.root
    }

    private fun initialize(inflater: LayoutInflater, container: ViewGroup?) {
        setupViewModel()
        setupDataBinding(inflater, container)
    }

    /**
     * DataBinding setup
     */
    private fun setupDataBinding(inflater: LayoutInflater, container: ViewGroup?) {
        binding = DataBindingUtil.inflate(inflater, provideLayout(), container, false)
        binding.apply {
            lifecycleOwner = this@CoreFragment
            setVariable(provideBindingId(), viewModel)
        }
    }

    /**
     *  ViewModel setup
     */
    private fun setupViewModel() {
        viewModel = ViewModelProvider
            .AndroidViewModelFactory
            .getInstance(this@CoreFragment.requireActivity().application)
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