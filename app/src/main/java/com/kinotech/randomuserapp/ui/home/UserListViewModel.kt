package com.kinotech.randomuserapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.kinotech.randomuserapp.model.UserFullData

class UserListViewModel : ViewModel() {
    private val randomUserRequest = RandomUserRequest()

    suspend fun generateUser(){
        randomUserRequest.loadUser()
    }

    fun getUser(): LiveData<List<UserFullData>>{
        return randomUserRequest.getUsers()
    }

}