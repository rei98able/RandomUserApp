package com.kinotech.randomuserapp.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: UserInfo)

    @Query("SELECT * FROM user_database")
    fun readAllData(): LiveData<List<UserInfo>>
}