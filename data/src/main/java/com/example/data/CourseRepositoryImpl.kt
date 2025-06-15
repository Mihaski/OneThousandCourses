package com.example.data

import android.content.Context
import com.example.data.database.DBModelCourse
import com.example.data.database.RoomDao
import com.example.data.network.RetrofitInterface
import com.example.domain.Course
import com.example.domain.CourseRepositoryInterface
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import java.io.File
import javax.inject.Inject

class CourseRepositoryImpl @Inject constructor(
    @ApplicationContext
    context: Context,
    private val retrofitInterface: RetrofitInterface,
    private val coursesMapper: CoursesMapper,
    private val databaseAccessInterface: RoomDao,
) : CourseRepositoryInterface {

    override fun getListCoursesFlow(): Flow<List<Course>> = flow {

        val localFlow = databaseAccessInterface.getAllCourses()
            .map { list -> list?.map { coursesMapper.dbModelToDomain(it) } ?: emptyList() }

        val localData = localFlow.first()

        if (localData.isEmpty()) {
            val cachedCourses = loadCoursesFromCacheFile()

            if (!cachedCourses.isNullOrEmpty()) {
                cachedCourses.map { coursesMapper.domainToDbModel(it) }
                    .forEach { databaseAccessInterface.addCourse(it) }
            } else {
                try {
                    val networkResponse = retrofitInterface.listCourses()
                    val courses = networkResponse.courses.map {
                        coursesMapper.domainToDbModel(
                            coursesMapper.networkToDomain(it)
                        )
                    }

                    databaseAccessInterface.clearCache()
                    courses.forEach { databaseAccessInterface.addCourse(it) }

                    saveCoursesToCacheFile(courses)
                } catch (e: Exception) {

                    emit(emptyList())
                }
            }
        }

        emitAll(localFlow)
    }

    private val cacheFile = File(context.cacheDir, "courses_cache.json")

    private fun saveCoursesToCacheFile(courses: List<DBModelCourse>) {
        val jsonString = Gson().toJson(courses)
        cacheFile.writeText(jsonString)
    }

    private suspend fun loadCoursesFromCacheFile(): List<Course>? = withContext(Dispatchers.IO) {
        if (cacheFile.exists()) {
            val jsonString = cacheFile.readText()
            val type = object : TypeToken<List<DBModelCourse>>() {}.type
            val dbList: List<DBModelCourse> = Gson().fromJson(jsonString, type)
            dbList.map { coursesMapper.dbModelToDomain(it) }
        } else {
            null
        }
    }
}