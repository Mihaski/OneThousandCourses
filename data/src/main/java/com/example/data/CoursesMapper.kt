package com.example.data

import com.example.data.database.DBModelCourse
import com.example.data.network.NetworkCourse
import com.example.domain.Course
import javax.inject.Inject

class CoursesMapper @Inject constructor() {

    fun networkToDomain(networkCourse: NetworkCourse) = Course(
        hasLike = networkCourse.hasLike,
        id = networkCourse.id,
        price = networkCourse.price,
        publishDate = networkCourse.publishDate,
        rate = networkCourse.rate,
        startDate = networkCourse.startDate,
        text = networkCourse.text,
        title = networkCourse.title,
    )

    fun domainToDbModel(course: Course) = DBModelCourse(
        hasLike = course.hasLike,
        id = course.id,
        price = course.price,
        publishDate = course.publishDate,
        rate = course.rate,
        startDate = course.startDate,
        text = course.text,
        title = course.title
    )

    fun dbModelToDomain(dbModelCourse: DBModelCourse) = Course(
        hasLike = dbModelCourse.hasLike,
        id = dbModelCourse.id,
        price = dbModelCourse.price,
        publishDate = dbModelCourse.publishDate,
        rate = dbModelCourse.rate,
        startDate = dbModelCourse.startDate,
        text = dbModelCourse.text,
        title = dbModelCourse.title
    )
}