package com.kinotech.randomuserapp.db

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.kinotech.randomuserapp.model.FullResult
import com.kinotech.randomuserapp.model.UserFullData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application){
    val readAllData: LiveData<List<UserInfo>>
    private val repository: UserRepository

    init{
        val userDao = UserDatabase.getDatabase(application).userDao()
        repository = UserRepository(userDao)
        readAllData = repository.readAllData
    }
    fun addUser(user: UserInfo){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }
}