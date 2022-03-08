package com.hakansoft.polishdictionary

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchResult(
    @SerialName("id")
    val id: Int,

    @SerialName("headword")
    val headword: String,

    @SerialName("embedded_definition")
    val embeddedDefinition: String,

    @SerialName("crossreferences")
    val crossReferences: String,

    @SerialName("rank")
    val rank: Int,

    @SerialName("highlights")
    val highlights: String
)