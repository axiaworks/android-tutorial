package com.axiaworks.tutorial.mvvm.repository

import com.axiaworks.tutorial.mvvm.response.QiitaItem
import retrofit2.http.GET
import retrofit2.http.Path

interface QiitaRepository {

    @GET("api/v2/tags/{tag}/items")
    suspend fun fetchTagItems(@Path("tag") tag: String): List<QiitaItem>
}