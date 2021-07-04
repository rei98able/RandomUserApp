package com.kinotech.randomuserapp.ui.user_page

import androidx.lifecycle.ViewModel
import com.kinotech.randomuserapp.databinding.UserPageBinding
import com.kinotech.randomuserapp.db.UserInfo

class UserPageViewModel : ViewModel() {
    private val userDataSetter = UserDataSetter()
    fun setData(binding: UserPageBinding, user: UserInfo){
        userDataSetter.setData(binding, user)
    }
}