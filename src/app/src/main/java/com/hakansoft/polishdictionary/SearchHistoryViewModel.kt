package com.hakansoft.polishdictionary

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class SearchHistoryViewModel(val dao: SearchHistoryDao) : ViewModel() {

    val words = dao.getAll()

    fun addSearchedWord(word: String) {
        viewModelScope.launch {
            val searchedWord = SearchHistory()
            searchedWord.word = word

            if (words.value != null) {
                if (words.value!!.size == 30) {
                    dao.delete(words.value!!.last())
                } else if (words.value!!.filter { a -> a.word.equals(word) }.any()) {
                    var sameWords = words.value!!.filter { a -> a.word.equals(word) }
                    for (w in sameWords) {
                        dao.delete(w)
                    }
                }
            }

            dao.insert(searchedWord)
        }
    }
}