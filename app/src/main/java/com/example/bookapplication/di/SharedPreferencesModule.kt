package com.example.bookapplication.di

import android.content.Context
import android.content.SharedPreferences
import com.example.bookapplication.extension.preferences
import dagger.Module
import dagger.Provides

@Module
class SharedPreferencesModule {

    @Provides
    fun provideSharedPreferences(context: Context): SharedPreferences {
        return context.preferences
    }
}