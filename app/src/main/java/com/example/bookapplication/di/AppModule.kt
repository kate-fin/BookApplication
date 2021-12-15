package com.example.bookapplication.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val app: Application) {//SomeModule
    @Provides
    open fun sayLoveDagger2(): Info {//providesInfo() - не вызывается в коде
        return Info("Love Dagger 2")
    }

//    @Provides
//    @Singleton
//    fun provideContext(): Context = app
}