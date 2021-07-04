package com.kinotech.randomuserapp.db

import androidx.lifecycle.LiveData
import com.kinotech.randomuserapp.model.FullResult
import com.kinotech.randomuserapp.model.UserFullData

class UserRepository(private val userDao: UserDao) {
    val readAllData: LiveData<List<UserInfo>> = userDao.readAllData()
    suspend fun addUser(user: UserInfo){
        userDao.addUser(user)
    }
}