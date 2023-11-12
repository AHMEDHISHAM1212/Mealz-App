package com.example.data.model

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.example.domain.model.Category
import com.google.gson.annotations.SerializedName

@Parcelize
data class CategoryDto(

	@field:SerializedName("strCategory")
	val categoryName: String? = null,

	@field:SerializedName("strCategoryDescription")
	val categoryDescription: String? = null,

	@field:SerializedName("idCategory")
	val categoryId: String? = null,

	@field:SerializedName("strCategoryThumb")
	val categoryImage: String? = null
) : Parcelable{

	fun toCategory():Category{

		return Category(
			strCategory = categoryName,
			strCategoryDescription = categoryDescription,
			idCategory = categoryId,
			strCategoryThumb = categoryImage
		)
	}
}