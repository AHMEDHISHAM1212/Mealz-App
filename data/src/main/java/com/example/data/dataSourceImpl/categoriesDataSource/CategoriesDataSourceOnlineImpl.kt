package com.example.data.dataSourceImpl.categoriesDataSource

import com.example.data.api.WebService
import com.example.data.dataSourceContract.CategoriesDataSource
import com.example.data.model.CategoryDto
import com.example.domain.model.Category
import javax.inject.Inject

class CategoriesDataSourceOnlineImpl @Inject constructor(
    private val webService: WebService
): CategoriesDataSource {
    override suspend fun getCategories(): List<Category?>? {
        val response = webService.getCategories()
        return response.categories?.map {
            it?.toCategory()
        }
    }
}