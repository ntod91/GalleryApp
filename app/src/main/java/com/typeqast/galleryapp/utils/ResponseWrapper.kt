package com.typeqast.galleryapp.utils

import androidx.lifecycle.Observer
import com.typeqast.core.ui.ICoreView
import com.typeqast.domain.wrappers.NetworkPolicy
import com.typeqast.domain.wrappers.Resource

abstract class ResponseWrapper<Data, Callback : ICoreView>(val callback: Callback) :
    Observer<Resource<Data>> {
    private var errorCallback: ErrorCallback? = null
    override fun onChanged(data: Resource<Data>) {
        object : ResponseHandler<Data, Resource<Data>, ICoreView>(data, callback) {
            override fun onSuccess(data: Data?) {
                this@ResponseWrapper.onSuccess(data)
            }

            override fun updateUIProgress(status: Int) {
                this@ResponseWrapper.updateUI(data.status)
            }

            override fun onError(error: Throwable?) {
                super.onError(error)
                this@ResponseWrapper.errorCallback?.onError(error)
            }
        }
    }

    fun setErrorCallback(errorErrorCallback: ErrorCallback): ResponseWrapper<Data, Callback> {
        this@ResponseWrapper.errorCallback = errorErrorCallback
        return this
    }

    open fun updateUI(status: Int) {
        callback.processUIStatus(status)
    }

    open fun asObserver() = this as Observer<Resource<Data>>

    abstract fun onSuccess(data: Data?)

    interface ErrorCallback {
        fun onError(throwable: Throwable?)
    }

}

private abstract class ResponseHandler<Data, Wrapper : Resource<Data>, Callback : ICoreView>(
    result: Wrapper,
    private val iView: Callback
) {

    init {
        processResult(result)
    }

    private fun processResult(result: Wrapper) {
        when (result.status) {
            NetworkPolicy.Status.SUCCESS -> {
                this.onSuccess(result.data)
                this.updateUIProgress(result.status)
            }
            NetworkPolicy.Status.ERROR -> {
                this.onError(result.error)
                this.updateUIProgress(result.status)
            }
            NetworkPolicy.Status.LOADING -> {
                this.updateUIProgress(result.status)
            }
            NetworkPolicy.Status.NO_INTERNET -> {
                this.updateUIProgress(result.status)
            }
        }
        iView.processUIStatus(result.status)
    }

    protected open fun onError(error: Throwable? = null) {
        iView.processError(error)
    }

    abstract fun onSuccess(data: Data?)
    abstract fun updateUIProgress(status: @NetworkPolicy.Status Int)


}
