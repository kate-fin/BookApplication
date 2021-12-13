package com.example.testapplication.interfaces

import com.example.bookapplication.models.BestSellersModel
import retrofit2.http.GET


interface RepoService {
    @GET("best-sellers/history.json")
    suspend fun getBestSellers(): BestSellersModel?
//
//    @GET("repos/{owner}/{name}")
//    fun getRepo(@Path("owner") owner: String?, @Path("name") name: String?): Single<Repo?>?
}