package com.typeqast.data.remote

import androidx.annotation.IntDef

annotation class NetworkPolicy {
    @Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
    @IntDef(
        Status.SUCCESS,
        Status.ERROR,
        Status.LOADING,
        Status.NO_INTERNET
    )
    @Retention(AnnotationRetention.SOURCE)
    annotation class Status {
        companion object {
            const val SUCCESS: Int = 0
            const val LOADING: Int = 1
            const val ERROR: Int = 2
            const val NO_INTERNET: Int = 3
        }
    }
}