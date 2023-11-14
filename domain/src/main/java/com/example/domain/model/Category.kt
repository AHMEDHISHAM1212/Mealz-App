package com.example.domain.model

import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Category(
	val name: String? = null,
	val description: String? = null,
	val id: String? = null,
	val image: String? = null
) : Parcelable