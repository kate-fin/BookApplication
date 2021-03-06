package com.example.bookapplication.source.remote

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor

object RetrofitModule {
    val client: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor { chain -> return@addInterceptor addApiKeyToRequests(chain) }
        .addInterceptor(getHttpLogger())
        .build()
//    private val retrofit = Retrofit.Builder()
//        .baseUrl("https://api.nytimes.com/svc/books/v3/lists/")
//        .addConverterFactory(GsonConverterFactory.create())
//        .client(client)
//        .build()
//    val booksApi: RepoService = retrofit.create()

    private fun addApiKeyToRequests(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
        val originalHttpUrl = chain.request().url
        val newUrl = originalHttpUrl.newBuilder()
            .addQueryParameter("api-key", "qOhPfYD6LXyqG8BY6QhIkYyqHDbHjxdG").build()
        request.url(newUrl)
        return chain.proceed(request.build())
    }

    // delete on production
    private fun getHttpLogger(): Interceptor {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        return logging
    }
}
