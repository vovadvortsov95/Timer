package com.example.vladimirdvortsov.timer.api

import com.example.vladimirdvortsov.timer.Constants
import retrofit2.converter.gson.GsonConverterFactory
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Retrofit



class ServerClient {

    private var retrofit: Retrofit? = null

    fun getClient(): ServerApi {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!.create(ServerApi :: class.java)
    }
}