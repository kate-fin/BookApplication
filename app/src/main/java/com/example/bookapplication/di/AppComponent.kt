package com.example.bookapplication.di

import com.example.bookapplication.MainActivity
import com.example.bookapplication.ui.best_sellers.list.BestSellersFragment
import com.example.bookapplication.ui.login.LoginFragment
import com.example.bookapplication.ui.settings.SettingsFragment
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class, NetworkModule::class, ViewModelModule::class,
    SharedPreferencesModule::class, UseCaseModule::class])
interface AppComponent {
    fun inject(app: MainActivity)
    fun inject(app: BestSellersFragment)
    fun inject(app: LoginFragment)
    fun inject(app: SettingsFragment)
}