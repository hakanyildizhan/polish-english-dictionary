package com.hakansoft.polishdictionary

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TopBarViewModel : ViewModel() {
    private var _mainText = MutableLiveData<String>("")
    private var _altText = MutableLiveData<String>("")

    val mainText: LiveData<String> = _mainText
    val altText: LiveData<String> = _altText

    fun setMainText(text: String) {
        _mainText.value = text
    }

    fun setAltText(text: String) {
        _altText.value = text
    }
}