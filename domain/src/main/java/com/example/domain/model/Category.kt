package com.example.domain.model

import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Category(
	val strCategory: String? = null,
	val strCategoryDescription: String? = null,
	val idCategory: String? = null,
	val strCategoryThumb: String? = null
) : Parcelable