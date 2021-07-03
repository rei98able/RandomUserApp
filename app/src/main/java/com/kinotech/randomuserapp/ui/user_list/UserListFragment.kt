package com.kinotech.randomuserapp.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.kinotech.randomuserapp.R
import com.kinotech.randomuserapp.databinding.FragmentUsersListBinding

class UserListFragment : Fragment() {
    private lateinit var binding: FragmentUsersListBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentUsersListBinding.inflate(inflater, container, false)

        return binding.root
    }

}