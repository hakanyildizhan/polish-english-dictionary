package com.hakansoft.polishdictionary

class MockApiCaller : IApiCaller {
    override fun getDefinitions(
        searchTerm: String,
        ignoreDiacritics: Boolean,
        partOfSpeech: String
    ): SearchResponse? {
        TODO("Not yet implemented")
        return null
    }
}