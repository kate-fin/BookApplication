package com.example.bookapplication.di

import com.example.bookapplication.MainActivity
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class])
interface AppComponent /*SomeComponent*/{
    fun inject(app: MainActivity)//inject
}