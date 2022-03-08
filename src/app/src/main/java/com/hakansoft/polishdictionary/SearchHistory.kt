package com.hakansoft.polishdictionary

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "search_history")
data class SearchHistory(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var word: String = ""
)
