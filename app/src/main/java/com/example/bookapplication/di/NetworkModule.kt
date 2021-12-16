package com.example.bookapplication.di

import com.example.bookapplication.interfaces.RepoService
import com.example.bookapplication.source.remote.RetrofitModule
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@Module
class NetworkModule {
    @Provides
    fun provideNetService(): RepoService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.nytimes.com/svc/books/v3/lists/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(RetrofitModule.client)
            .build()
        return retrofit.create()
    }
}