package com.kinotech.randomuserapp.ui.user_page

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.kinotech.randomuserapp.R
import com.kinotech.randomuserapp.databinding.UserPageBinding
import com.kinotech.randomuserapp.db.UserInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserPageFragment(private val user: UserInfo) : Fragment() {
    private lateinit var binding: UserPageBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = UserPageBinding.inflate(inflater, container, false)
        val viewModel: UserPageViewModel by viewModels()
        binding.apply {
            lifecycleScope.launch(Dispatchers.Main) {
                viewModel.setData(binding, user)
            }
            btnBack.setOnClickListener {
                fragmentManager?.popBackStack()
            }
            btnCall.setOnClickListener {
                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + user.phone))
                startActivity(intent)
            }
            btnEmail.setOnClickListener {
                val intent = Intent(Intent.ACTION_SENDTO)
                intent.putExtra(Intent.EXTRA_SUBJECT, "Subject of email")
                intent.putExtra(Intent.EXTRA_TEXT, "Body of email")
                intent.data =
                    Uri.parse("mailto:" + user.email)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            }

        }
        return binding.root
    }
}