package com.example.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [DBModelCourse::class], version = 1, exportSchema = false)
abstract class TenHundredRoomDatabase : RoomDatabase() {

    abstract fun databaseAccessInterface(): RoomDao

    companion object {

        private var INSTANCE: TenHundredRoomDatabase? = null
        private val LOCK = Any()
        private const val DB_NAME = "course.db"

        fun getInstance(context: Context): TenHundredRoomDatabase {
            INSTANCE?.let {
                return it
            }
            synchronized(LOCK) {
                INSTANCE?.let {
                    return it
                }
            }
            val db = Room.databaseBuilder(
                context,
                TenHundredRoomDatabase::class.java,
                DB_NAME
            ).build()
            INSTANCE = db
            return db
        }
    }
}