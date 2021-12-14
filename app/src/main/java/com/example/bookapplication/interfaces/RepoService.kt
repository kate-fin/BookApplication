package com.example.bookapplication.interfaces

import com.example.bookapplication.source.remote.models.BestSellersNetModel
import retrofit2.http.GET


interface RepoService {
    @GET("best-sellers/history.json")
    suspend fun getBestSellers(): BestSellersNetModel?
//
//    @GET("repos/{owner}/{name}")
//    fun getRepo(@Path("owner") owner: String?, @Path("name") name: String?): Single<Repo?>?
}