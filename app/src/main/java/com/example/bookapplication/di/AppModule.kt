package com.example.bookapplication.di

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.bookapplication.ui.best_sellers.list.BestSellersViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
class AppModule(private val application: Application) {

    @Provides
    @Singleton
    fun provideContext(): Context = application
}

