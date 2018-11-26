package com.example.vladimirdvortsov.timer.api

import com.google.gson.JsonObject
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path


interface ServerApi {

    @POST("{timer}")
    fun postTimer(@Path("timer")timer: JsonObject): Observable<Void>

}