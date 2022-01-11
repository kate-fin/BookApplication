package com.example.bookapplication.di

import com.example.bookapplication.domain.LoginUseCase
import com.example.bookapplication.domain.PasswordUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {
    @Provides
    fun provideLoginUseCase() = LoginUseCase()

    @Provides
    fun providePasswordUseCase() = PasswordUseCase()
}