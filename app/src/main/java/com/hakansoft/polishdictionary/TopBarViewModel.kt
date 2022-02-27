package com.hakansoft.polishdictionary

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TopBarViewModel : ViewModel() {
    val mainText: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val altText: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun setMainText(text: String) {
        this.mainText.value = text
    }

    fun setAltText(text: String) {
        this.altText.value = text
    }
}

/*
class TopBarViewModel constructor(mainText: String, altText: String) : ViewModel() {
    val mainText = MutableLiveData<String>()
    val altText = MutableLiveData<String>()

    constructor(mainText: String) : this(mainText, "")

    init {
        this.mainText.value = mainText
        this.altText.value = altText
    }
}
*/