package com.hakansoft.polishdictionary

import com.google.gson.annotations.SerializedName

data class SearchResult(
    @SerializedName("id")
    val id: Int,

    @SerializedName("headword")
    val headword: String,

    @SerializedName("embedded_definition")
    val embeddedDefinition: String,

    @SerializedName("crossreferences")
    val crossReferences: String,

    @SerializedName("rank")
    val rank: Int,

    @SerializedName("highlights")
    val highlights: String
)