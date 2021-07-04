package com.kinotech.randomuserapp.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kinotech.randomuserapp.model.*

@Entity(tableName = "user_database")
data class UserInfo(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val name: String,
    val gender: String,
    val location: String,
    val email: String,
    val age: Int,
    val phone: String,
    val pictureSmall: String,
    val pictureBig: String
)