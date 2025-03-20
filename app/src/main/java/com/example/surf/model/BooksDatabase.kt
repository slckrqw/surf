package com.example.surf.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.surf.interfaces.BookDao

@Database(
    entities = [BookEntity::class],
    version = 1,
    exportSchema = false
)
abstract class BooksDatabase : RoomDatabase() {

    abstract fun bookDao(): BookDao

    companion object {

        @Volatile
        private var Instance: BooksDatabase? = null

        fun getDatabase(context: Context): BooksDatabase {
            // if the Instance is not null, return it, otherwise create a new database instance.
            return Instance ?: synchronized(this){
                Room
                    .databaseBuilder(
                        context,
                        BooksDatabase::class.java,
                        "books_database"
                    )
                    .fallbackToDestructiveMigration()
                    .build()
                    .also {
                        Instance = it
                    }
            }
        }
    }
}