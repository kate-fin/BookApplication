package com.example.bookapplication.ui.best_sellers.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookapplication.interfaces.RepoService
import com.example.bookapplication.ui.best_sellers.BookModel
import com.example.bookapplication.source.remote.RetrofitModule
import kotlinx.coroutines.launch
import javax.inject.Inject


class BestSellersViewModel @Inject constructor(private val booksApi: RepoService): ViewModel() {
    private val _bestSellersLiveData = MutableLiveData<List<BookModel>>()
    val bestSellersLiveData: LiveData<List<BookModel>> get() = _bestSellersLiveData
    private val _spinner = MutableLiveData<Boolean>()
    val spinner: LiveData<Boolean> get() = _spinner
    private val _error = MutableLiveData<Boolean>()
    val error: LiveData<Boolean> get() = _spinner

    fun getBestSellers(){
        viewModelScope.launch {
            _spinner.postValue(true)
            val booksNet = booksApi.getBestSellers()
            if (booksNet != null) {
                val books = booksNet.results.map {
                    BookModel(title = it.title, author = it.author, isFavourite = false, description = it.description)
                }
                _bestSellersLiveData.postValue(books)
                _spinner.postValue(false)
            } else {
                _error.postValue(true)
            }
        }
    }
}