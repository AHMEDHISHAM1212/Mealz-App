package com.example.data.dataSourceImpl.categoriesDataSource

import com.example.data.dataSourceContract.CategoriesDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class di {

    @Binds
    abstract fun provideCategoriesDataSource(
        categoriesDataSourceOnlineImpl: CategoriesDataSourceOnlineImpl
    ): CategoriesDataSource
}