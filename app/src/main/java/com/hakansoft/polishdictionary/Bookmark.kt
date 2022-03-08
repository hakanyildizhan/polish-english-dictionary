package com.hakansoft.polishdictionary

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bookmark")
data class Bookmark(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var word: String = "",
    var definition: String = ""
)
