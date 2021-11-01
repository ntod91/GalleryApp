package com.typeqast.data.remote

import com.typeqast.data.remote.api.GalleryAPI
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object NetworkModule {
    var remote: GalleryAPI


    init {
        val client: OkHttpClient = OkHttpClient()
            .newBuilder()
            .connectTimeout(500, TimeUnit.MILLISECONDS)
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .addInterceptor {
                val modifiedRequest = it
                    .request()
                    .newBuilder()
                    .header("Accept", "application/json")
                    .header("Content-type", "application/json")
                    .method(it.request().method, it.request().body)
                    .build()
                it.proceed(modifiedRequest)
            }.build()

        val retrofit = Retrofit
            .Builder()
            .client(client)
            .baseUrl("https://run.mocky.io/v3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        remote = retrofit.create(GalleryAPI::class.java)
    }
}
