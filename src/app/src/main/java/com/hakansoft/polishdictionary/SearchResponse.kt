package com.hakansoft.polishdictionary

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchResponse(
    @SerialName("total_entries_found")
    val totalEntriesFound: String,

    @SerialName("total_pages_found")
    val totalPagesFound: Int,

    @SerialName("current_page")
    val currentPage: Int,

    @SerialName("current_page_size")
    val currentPageSize: Int,

    @SerialName("current_entries_found")
    val currentEntriesFound: Int,

    @SerialName("has_next_page")
    val hasNextPage: Boolean,

    @SerialName("next_page")
    val nextPage: Int,

    @SerialName("found_as")
    val foundAs: String,

    @SerialName("user_search_string")
    val userSearchString: String,

    @SerialName("search_model")
    val searchModel: String,

    @SerialName("results")
    val results: List<SearchResult>
)
