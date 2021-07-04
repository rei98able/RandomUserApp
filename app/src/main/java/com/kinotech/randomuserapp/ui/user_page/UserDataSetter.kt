package com.kinotech.randomuserapp.ui.user_page

import com.bumptech.glide.Glide
import com.kinotech.randomuserapp.R
import com.kinotech.randomuserapp.databinding.UserPageBinding
import com.kinotech.randomuserapp.db.UserInfo

class UserDataSetter {
    fun setData(binding: UserPageBinding, user: UserInfo){
        binding.apply{
            Glide
                .with(binding.root)
                .load(user.pictureBig)
                .error(R.drawable.ic_baseline_photo_camera_24)
                .into(userPhoto)
            userName.text = user.name
            userGender.text = user.gender
            userAge.text = user.age.toString()
            userPhone.text = user.phone
            userEmail.text = user.email
            userAddress.text = user.location
        }
    }
}