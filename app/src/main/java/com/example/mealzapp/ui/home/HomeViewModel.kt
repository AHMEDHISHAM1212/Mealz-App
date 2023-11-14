package com.example.mealzapp.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Category
import com.example.domain.usecase.GetCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val categoriesUseCase: GetCategoriesUseCase)
    : ViewModel() , CategoriesHomeContract.ViewModel {
    val categoriesLiveData = MutableLiveData<List<Category?>?>()

    private val _states = MutableLiveData<CategoriesHomeContract.State>()
    override val states = _states

    private val _event = MutableLiveData<CategoriesHomeContract.Event>()
    override val event = _event

    override fun invokeAction(action: CategoriesHomeContract.Action) {
        when(action){
            CategoriesHomeContract.Action.CategoryClicked -> TODO()
            CategoriesHomeContract.Action.LoadCategories -> loadCategories()
        }
    }

    private fun loadCategories() {
        viewModelScope.launch {
            try {
                _states.postValue(CategoriesHomeContract.State.Loading("Loading.."))
                val data = categoriesUseCase.invoke()
                _states.postValue(CategoriesHomeContract.State.Success(data))
            }catch (e:Exception){
                _states.postValue(CategoriesHomeContract.State.Error(e.localizedMessage))
            }
        }
    }

}


