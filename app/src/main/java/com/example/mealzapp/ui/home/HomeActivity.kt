package com.example.mealzapp.ui.home

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.domain.model.Category
import com.example.mealzapp.R
import com.example.mealzapp.databinding.ActivityHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private lateinit var _viewBinding : ActivityHomeBinding
    private lateinit var viewModel: HomeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        callingViewModel()
    }

    private fun callingViewModel() {
        viewModel.states.observe(this,::handelState)
        viewModel.event.observe(this,::handelEvents)
        viewModel.invokeAction(CategoriesHomeContract.Action.LoadCategories)

    }

    private fun handelEvents(event: CategoriesHomeContract.Event?) {
        when(event){
            is CategoriesHomeContract.Event.NavigateToSubCategory -> TODO()
            null -> TODO()
        }
    }

    private fun handelState(state: CategoriesHomeContract.State) {
        when(state){
            is CategoriesHomeContract.State.Error -> showError(state.message)
            is CategoriesHomeContract.State.Loading -> showLoading(state.message)
            is CategoriesHomeContract.State.Success -> bindCategories(state.category)
        }
    }

    private fun showLoading(message: String) {
        _viewBinding.tvError.isVisible= false
        _viewBinding.tvLoading.isVisible= true
        _viewBinding.tvLoading.text="Loading..."

    }

    private fun showError(message: String) {
        _viewBinding.tvError.isVisible= true
        _viewBinding.tvLoading.isVisible= false
        _viewBinding.tvLoading.text=message
    }

    private fun bindCategories(category: List<Category?>?) {
        _viewBinding.tvError.isVisible= false
        _viewBinding.tvLoading.isVisible= false

        categoryAdapter.bindCategories(category)
    }


    private val categoryAdapter=HomeCategoryAdapter(null)
    private fun initViews(){

        _viewBinding= DataBindingUtil
            .setContentView(this,R.layout.activity_home)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        _viewBinding?.rvCategory?.adapter=categoryAdapter
    }
}