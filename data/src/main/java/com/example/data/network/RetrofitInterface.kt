package com.example.data.network

import retrofit2.http.GET

interface RetrofitInterface {

    @GET("uc?id=15arTK7XT2b7Yv4BJsmDctA4Hg-BbS8-q&export=download")
    suspend fun listCourses(): NetworkListCourses
}