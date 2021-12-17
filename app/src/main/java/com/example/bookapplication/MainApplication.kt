package com.example.bookapplication

import android.app.Application
import com.example.bookapplication.di.AppComponent
import com.example.bookapplication.di.AppModule
import com.example.bookapplication.di.DaggerAppComponent

class MainApplication : Application() {

    lateinit var  appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }
}