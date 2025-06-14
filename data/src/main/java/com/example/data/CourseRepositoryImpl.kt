package com.example.data

import com.example.data.network.RetrofitInterface
import com.example.domain.Course
import com.example.domain.CourseRepositoryInterface
import javax.inject.Inject

class CourseRepositoryImpl @Inject constructor(
    private val retrofitInterface: RetrofitInterface,
    private val coursesMapper: CoursesMapper,
) : CourseRepositoryInterface {

    override suspend fun getCourseDomainInterface(courseId: Int): Course =
        getCoursesListDomainInterface().find { it.id == courseId } ?: Course(
            false,
            -1,
            "0",
            "",
            "",
            "",
            "",
            ""
        )


    override suspend fun getCoursesListDomainInterface(): List<Course> =
        coursesMapper.listNetworkToDomain(retrofitInterface.listCourses().courses)
}