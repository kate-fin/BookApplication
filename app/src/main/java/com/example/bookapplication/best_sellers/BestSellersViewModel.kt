package com.example.bookapplication.best_sellers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookapplication.models.BestSellersModel
import com.example.bookapplication.source.remote.RetrofitModule
import kotlinx.coroutines.launch

class BestSellersViewModel: ViewModel() {
    private val _bestSellersLiveData = MutableLiveData<BestSellersModel>()
    val bestSellersLiveData: LiveData<BestSellersModel> get() = _bestSellersLiveData
    private val _spinner = MutableLiveData<Boolean>()
    val spinner: LiveData<Boolean> get() = _spinner
    private val _error = MutableLiveData<Boolean>()
    val error: LiveData<Boolean> get() = _spinner

    fun getBestSellers(){
        viewModelScope.launch {
            _spinner.postValue(true)
            val a = RetrofitModule.booksApi.getBestSellers()
            if (a != null) {
                _bestSellersLiveData.postValue(a!!)
                _spinner.postValue(false)
            } else {
                _error.postValue(true)
            }
        }
    }
}