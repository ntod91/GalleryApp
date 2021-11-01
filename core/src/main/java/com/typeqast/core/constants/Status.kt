package com.typeqast.core.constants

@Retention(AnnotationRetention.SOURCE)
annotation class Status {
    companion object {
        const val SUCCESS: Int = 0
        const val LOADING: Int = 1
        const val ERROR: Int = 2
        const val NO_INTERNET: Int = 3
    }
}

