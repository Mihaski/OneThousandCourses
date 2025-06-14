package com.example.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "courses_table")
data class DBModelCourse(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val hasLike: Boolean,
    val price: String,
    val publishDate: String,
    val rate: String,
    val startDate: String,
    val text: String,
    val title: String,
)