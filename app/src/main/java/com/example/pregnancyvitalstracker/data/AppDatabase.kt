package com.example.pregnancyvitalstracker.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [VitalsEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun vitalsDao(): VitalsDao

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "vitals_db"
                ).build().also { INSTANCE = it }
            }
        }
    }
}
