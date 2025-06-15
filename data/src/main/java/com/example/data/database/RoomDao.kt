package com.example.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface RoomDao {

    @Query("select * from courses_table")
    fun getAllCourses(): Flow<List<DBModelCourse>?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCourse(courseDBModel: DBModelCourse)

    @Query("SELECT * FROM courses_table WHERE id=:courseDBModelId LIMIT 1")
    suspend fun getShopItem(courseDBModelId: Int): DBModelCourse

    //    @Query("DELETE FROM courses_table WHERE id=:courseDBModelId")
    @Delete
    suspend fun deleteCourse(courseDBModel: DBModelCourse)

    @Query("DELETE FROM courses_table")
    suspend fun clearCache()
}