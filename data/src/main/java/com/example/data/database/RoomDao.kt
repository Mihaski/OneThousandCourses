package com.example.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query

@Dao
interface RoomDao {

    @Query("select * from courses_table")
    fun getAllCourses():LiveData<List<DBModelCourse>>
}