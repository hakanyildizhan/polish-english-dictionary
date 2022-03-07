package com.hakansoft.polishdictionary

interface IApiCaller {
    suspend fun getDefinitions(searchTerm: String, ignoreDiacritics: Boolean, partOfSpeech: String = "all") : SearchResponse?
}