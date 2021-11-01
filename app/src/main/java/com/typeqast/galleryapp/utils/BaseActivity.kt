package com.typeqast.galleryapp.utils

import android.util.Log
import android.widget.Toast
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import com.typeqast.core.constants.Status
import com.typeqast.core.ui.activites.CoreActivity
import com.typeqast.galleryapp.BR
import com.typeqast.galleryapp.R

abstract class BaseActivity<VDB : ViewDataBinding, VM : ViewModel> : CoreActivity<VDB, VM>() {


    override fun processUIStatus(status: Int) {
        when (status) {
            Status.LOADING -> showDialog()
            Status.NO_INTERNET -> showMessage(getString(R.string.error_no_internet))
            else -> dismissDialog()
        }
    }

    override fun showMessage(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showDialog() {

    }

    override fun dismissDialog() {

    }

    override fun processError(error: Throwable?) {
        Log.e(provideTAG(), error?.message, error)
    }

    override fun provideBindingId(): Int {
        return BR.vm
    }

    override fun onDestroy() {
        dismissDialog()
        super.onDestroy()
    }

}