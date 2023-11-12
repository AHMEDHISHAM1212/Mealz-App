package com.example.data.api

import com.example.data.model.CategoryResponse
import retrofit2.http.GET

interface WebService {

    @GET("categories.php")
    suspend fun getCategories(): CategoryResponse
}