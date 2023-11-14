package com.example.mealzapp.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.Category
import com.example.mealzapp.databinding.ItemCategoryBinding

class HomeCategoryAdapter(var categoryList: List<Category?>?) : RecyclerView.Adapter<HomeCategoryAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding = ItemCategoryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemCategory =categoryList?.get(position)!!
        holder.bind(itemCategory)
    }

    override fun getItemCount(): Int = categoryList?.size?:0

    fun bindCategories(categories: List<Category?>?) {
        this.categoryList= categoryList
        notifyDataSetChanged()
    }

    class ViewHolder (private val itemBinding : ItemCategoryBinding):
            RecyclerView.ViewHolder(itemBinding.root){
                fun bind(category: Category){
                    itemBinding.tvCategoryName.text=  category.name
                    itemBinding.executePendingBindings()

                }
            }
}