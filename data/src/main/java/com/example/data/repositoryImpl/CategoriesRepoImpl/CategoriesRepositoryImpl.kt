package com.example.data.repositoryImpl.CategoriesRepoImpl

import com.example.data.dataSourceImpl.categoriesDataSource.CategoriesDataSourceOnlineImpl
import com.example.domain.model.Category
import com.example.domain.repository.CategoriesRepository
import javax.inject.Inject

class CategoriesRepositoryImpl @Inject constructor(
    private val categoriesDataSourceOnlineImpl: CategoriesDataSourceOnlineImpl
) : CategoriesRepository {
    override suspend fun getCategories(): List<Category?>? {
       return categoriesDataSourceOnlineImpl.getCategories()
    }
}