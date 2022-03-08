package com.hakansoft.polishdictionary

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class SearchHistoryViewModelFactory(private val dao: SearchHistoryDao) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SearchHistoryViewModel::class.java)) {
            return SearchHistoryViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown viewmodel")
    }
}