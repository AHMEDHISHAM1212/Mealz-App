package com.example.data.model

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class CategoryResponse(

	@field:SerializedName("categories")
	val categories: List<CategoryDto?>? = null
) : Parcelable