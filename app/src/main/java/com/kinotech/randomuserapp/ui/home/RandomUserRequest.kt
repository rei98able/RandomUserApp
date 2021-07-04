package com.kinotech.randomuserapp.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kinotech.randomuserapp.api.APIEndpoints
import com.kinotech.randomuserapp.api.ServiceBuilder
import com.kinotech.randomuserapp.model.FullResult
import com.kinotech.randomuserapp.model.UserFullData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Response

class RandomUserRequest {
    private val request = ServiceBuilder.buildService(APIEndpoints::class.java)
    private val users = MutableLiveData<List<UserFullData>>()

    suspend fun loadUser() = withContext(Dispatchers.IO){
        val call = request.generateUser()
        call.enqueue(
            object : retrofit2.Callback<FullResult> {
                override fun onFailure(call: Call<FullResult>, t: Throwable) {
                    Log.d("api", "onFailure:$t ")
                }

                override fun onResponse(
                    call: Call<FullResult>,
                    response: Response<FullResult>
                ) {
                    if (response.isSuccessful) {
                        Log.d("api", "response is ${response.body()}")
                        users.postValue(response.body()!!.results)
                    }
                }
            }
        )
    }

    fun getUsers(): LiveData<List<UserFullData>> {
        return users
    }
}