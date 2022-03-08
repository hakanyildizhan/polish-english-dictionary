package com.hakansoft.polishdictionary

import android.text.SpannableString
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class SearchResultRowViewModel : ViewModel() {
    val rowText: MutableLiveData<SpannableString> by lazy {
        MutableLiveData<SpannableString>()
    }

    val rowTextString: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}