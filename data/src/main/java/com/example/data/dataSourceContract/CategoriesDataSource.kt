package com.example.data.dataSourceContract

import com.example.domain.model.Category

interface CategoriesDataSource {

    suspend fun getCategories(): List<Category?>?
}