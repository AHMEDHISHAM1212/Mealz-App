package com.example.domain.usecase

import com.example.domain.model.Category
import com.example.domain.repository.CategoriesRepository
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(
    private val categoriesRepository: CategoriesRepository
){
    suspend fun invoke(): List<Category?>?{
        return categoriesRepository.getCategories()
    }
}