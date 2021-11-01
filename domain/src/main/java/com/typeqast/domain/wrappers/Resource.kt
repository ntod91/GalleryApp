package com.typeqast.domain.wrappers

class Resource<out T>(
    val status: @NetworkPolicy.Status Int,
    val data: T? = null,
    val error: Throwable? = null
) {
    companion object {
        fun <T> success(data: T?, error: Throwable?) =
            Resource(
                NetworkPolicy.Status.SUCCESS,
                data,
                error
            )

        fun <T> error(data: T?, error: Throwable?) =
            Resource(
                NetworkPolicy.Status.ERROR,
                data,
                error
            )

        fun <T> loading() =
            Resource(
                NetworkPolicy.Status.LOADING,
                null,
                null
            )

        fun <T> noInternet(data: T?, error: Throwable?) =
            Resource(
                NetworkPolicy.Status.NO_INTERNET,
                data,
                error
            )
    }
}
