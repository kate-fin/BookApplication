package com.example.bookapplication.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bookapplication.ui.ViewModelFactory
import com.example.bookapplication.ui.best_sellers.list.BestSellersViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(BestSellersViewModel::class)
    abstract fun bestSellersViewModel(viewModel: BestSellersViewModel): ViewModel

}