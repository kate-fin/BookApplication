package com.example.bookapplication

import android.app.Application
import com.example.bookapplication.di.AppComponent
import com.example.bookapplication.di.DaggerAppComponent

class MainApplication : Application() {

    lateinit var  appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().build()
    }

//    protected fun applicationInjector(): AndroidInjector<out DaggerApplication?> {
//        val component: ApplicationComponent =
//            DaggerApplicationComponent.builder().application(this).build()
//        component.inject(this)
//        return component
//    }
}