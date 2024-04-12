package com.example.myfitness

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.navigation.NavController
import com.example.myfitness.data.MainDb
import com.example.myfitness.data.Users
import kotlinx.coroutines.launch

class MainViewModel(val database: MainDb) : ViewModel() {
    val nameUser = mutableStateOf("")
    val loginUser = mutableStateOf("")
    val passwordUser = mutableStateOf("")
    fun insertNewUser() = viewModelScope.launch {
        val newUser = Users(
            name = nameUser.value,
            login = loginUser.value,
            password = passwordUser.value
        )
        database.dao.insertItemUser(newUser)
    }

    fun checkLoginAndPassword(enteredLogin: String, enteredPassword: String, navController: NavController) {
        viewModelScope.launch {
            val user = database.dao.getUserByLoginAndPassword(enteredLogin, enteredPassword)
            if (user != null) {
                navController.navigate("TrainScreen")
            }
        }
    }

    companion object {
        val factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                val database = (checkNotNull(extras[APPLICATION_KEY]) as App).database
                return MainViewModel(database) as T
            }
        }
    }
}