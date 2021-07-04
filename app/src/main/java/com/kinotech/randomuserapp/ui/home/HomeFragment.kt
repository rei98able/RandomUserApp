package com.kinotech.randomuserapp.ui.home

import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.kinotech.randomuserapp.R
import com.kinotech.randomuserapp.databinding.FragmentHomeBinding
import com.kinotech.randomuserapp.db.UserInfo
import com.kinotech.randomuserapp.db.UserViewModel
import com.kinotech.randomuserapp.model.UserFullData
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val userListViewModel: UserListViewModel by viewModels()
        val userViewModel: UserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        binding.apply {
            loadUser.setOnClickListener {
                val progressDialog = ProgressDialog(context)
                progressDialog.setTitle(getString(R.string.add_user))
                progressDialog.setMessage(getString(R.string.please_wait))
                progressDialog.setCanceledOnTouchOutside(false)
                progressDialog.show()
                lifecycleScope.launch {
                    userListViewModel.generateUser()
                    userListViewModel.getUser().observe(viewLifecycleOwner,
                        { user ->
                            val userProcessed = userInfoProcessing(user)
                            userViewModel.addUser(userProcessed)
                            Toast.makeText(context, "Succesfully added!", Toast.LENGTH_LONG).show()
                            progressDialog.dismiss()
                        })
                }

            }
        }

        return binding.root
    }

    private fun userInfoProcessing(user: List<UserFullData>): UserInfo {
        val id = user[0].login.uuid
        val name = user[0].name.first + " " + user[0].name.last
        val gender = user[0].gender
        val location =
            user[0].location.state + "\n" +
                    user[0].location.city + " " +
                    user[0].location.street.number + " " +
                    user[0].location.street.name
        val email = user[0].email
        val age = user[0].dob.age
        val phone = "+1" + user[0].phone
        val pictureSmall = user[0].picture.thumbnail
        val pictureBig = user[0].picture.large
        return UserInfo(id, name, gender, location, email, age, phone, pictureSmall, pictureBig)
    }


}