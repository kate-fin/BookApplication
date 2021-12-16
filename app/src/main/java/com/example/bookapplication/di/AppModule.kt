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
class AppModule {//SomeModule
    @Provides
    fun sayLoveDagger2(): Info {//providesInfo() - не вызывается в коде
        return Info("Love Dagger 2")
    }

//    @Provides
//    @Singleton
//    fun provideContext(): Context = app
}

