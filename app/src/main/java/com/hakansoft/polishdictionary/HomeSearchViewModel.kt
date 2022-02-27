package com.hakansoft.polishdictionary

import android.view.View
import android.widget.Spinner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeSearchViewModel : ViewModel() {

    val partOfSpeechTypes = listOf<String>(
        "all",
        "noun",
        "verb",
        "adj",
        "adverb",
        "prep",
        "prefix",
        "conj",
        "interj",
        "number",
        "pronoun",
        "onomat",
        "exclam",
        "suffix"
    )
}