package com.hakansoft.polishdictionary

import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName("total_entries_found")
    val totalEntriesFound: String,

    @SerializedName("total_pages_found")
    val totalPagesFound: Int,

    @SerializedName("current_page")
    val currentPage: Int,

    @SerializedName("current_page_size")
    val currentPageSize: Int,

    @SerializedName("current_entries_found")
    val currentEntriesFound: Int,

    @SerializedName("has_next_page")
    val hasNextPage: Boolean,

    @SerializedName("next_page")
    val nextPage: Int,

    @SerializedName("found_as")
    val foundAs: String,

    @SerializedName("user_search_string")
    val userSearchString: String,

    @SerializedName("search_model")
    val searchModel: String,

    @SerializedName("results")
    val results: List<SearchResult>
)
