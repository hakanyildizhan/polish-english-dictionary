package com.hakansoft.polishdictionary

interface IApiCaller {
    fun getDefinitions(searchTerm: String, ignoreDiacritics: Boolean, partOfSpeech: String = "all") : SearchResponse?
}