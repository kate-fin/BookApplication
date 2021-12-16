package com.example.bookapplication.di

import com.example.bookapplication.MainActivity
import com.example.bookapplication.ui.best_sellers.list.BestSellersFragment
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class, NetworkModule::class, ViewModelModule::class])
interface AppComponent /*SomeComponent*/{
    fun inject(app: MainActivity)//inject
    fun inject(app: BestSellersFragment)
}