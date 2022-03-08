package com.hakansoft.polishdictionary

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TopBarViewModel : ViewModel() {
    private var _mainText = MutableLiveData<String>("")
    private var _altText = MutableLiveData<String>("")
    private var _definitions = MutableLiveData<List<List<HtmlDefinition>>>()
    private var _isLoading = MutableLiveData<Boolean>(true)

    val mainText: LiveData<String> = _mainText
    val altText: LiveData<String> = _altText
    val definitions: LiveData<List<List<HtmlDefinition>>> = _definitions
    val isLoading: LiveData<Boolean> = _isLoading

    fun setMainText(text: String) {
        _mainText.postValue(text)
    }

    fun setAltText(text: String) {
        _altText.postValue(text)
    }

    fun setDefinitions(definitions: List<List<HtmlDefinition>>) {
        _definitions.postValue(definitions)
    }

    fun setIsLoading(isLoading: Boolean) {
        _isLoading.postValue(isLoading)
    }
}