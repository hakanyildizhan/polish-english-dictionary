package com.hakansoft.polishdictionary

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface SearchHistoryDao {
    @Insert
    suspend fun insert(searchHistory: SearchHistory)

    @Delete
    suspend fun delete(searchHistory: SearchHistory)

    @Query("SELECT * FROM search_history ORDER BY id DESC")
    fun getAll(): LiveData<List<SearchHistory>>
}