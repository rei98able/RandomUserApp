package com.kinotech.randomuserapp.ui.user_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.kinotech.randomuserapp.databinding.FragmentUsersListBinding
import com.kinotech.randomuserapp.db.UserInfo
import com.kinotech.randomuserapp.db.UserViewModel

class UserListFragment : Fragment() {
    private lateinit var binding: FragmentUsersListBinding
    private var adapter: UserAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentUsersListBinding.inflate(inflater, container, false)
        val userViewModel: UserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        binding.apply {
            recyclerviewLists.setHasFixedSize(true)
            recyclerviewLists.layoutManager = LinearLayoutManager(context)

            userViewModel.readAllData.observe(viewLifecycleOwner, { users ->
                adapter = context?.let{ UserAdapter(users, requireContext()) }
                recyclerviewLists.adapter = adapter
            })




        }
        return binding.root
    }

}