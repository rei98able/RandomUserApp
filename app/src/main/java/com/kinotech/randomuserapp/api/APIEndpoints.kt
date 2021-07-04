package com.kinotech.randomuserapp.api

import com.kinotech.randomuserapp.model.FullResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface APIEndpoints {
    @GET("api/?nat=us")
    fun generateUser(): Call<FullResult>
}
