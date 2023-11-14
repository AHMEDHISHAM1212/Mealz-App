package com.example.mealzapp.ui.home

import androidx.lifecycle.LiveData
import com.example.domain.model.Category

class CategoriesHomeContract {

    interface ViewModel{
        val states: LiveData<State>
        val event: LiveData<Event>
        fun invokeAction(action: Action)
    }
    sealed class State{
        class Success(val category: List<Category?>?) : State()
        class Error(val message: String) : State()
        class Loading(val message: String) : State()
    }
    sealed class Event{
        class NavigateToSubCategory(category: Category) : Event()
    }
    sealed class Action{
        object LoadCategories : Action()
        object CategoryClicked : Action()
    }
}