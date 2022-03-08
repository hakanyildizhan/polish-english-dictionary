package com.hakansoft.polishdictionary

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [SearchHistory::class], version = 1, exportSchema = false)
abstract class DictionaryDb : RoomDatabase() {

    companion object {
        @Volatile
        private var INSTANCE: DictionaryDb? = null

        fun getInstance(context: Context): DictionaryDb {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DictionaryDb::class.java,
                        "dictionary_database"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

    abstract val searchHistoryDao: SearchHistoryDao
}