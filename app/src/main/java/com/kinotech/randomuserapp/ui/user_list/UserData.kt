package com.kinotech.randomuserapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

data class FullResult(
    val results: List<UserFullData>
)

data class UserFullData(
    val name: Name,
    val gender: String,
    val location: Location,
    val email: String,
    val dob: Age,
    val phone: String,
    val login: Login,
    val picture: Picture
)

data class Login(
    val uuid: String
)

data class Picture(
    val large: String,
    val thumbnail: String
)

data class Name(
    val first: String,
    val last: String
)

data class Age(
    val age: Int
)

data class Location(
    val street: Street,
    val city: String,
    val state: String
)
data class Street(
    val name: String,
    val number: String
)


