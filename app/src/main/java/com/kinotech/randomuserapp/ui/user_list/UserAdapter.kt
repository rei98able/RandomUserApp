package com.kinotech.randomuserapp.ui.user_list

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.kinotech.randomuserapp.R
import com.kinotech.randomuserapp.databinding.UserItemBinding
import com.kinotech.randomuserapp.db.UserInfo
import com.kinotech.randomuserapp.ui.user_page.UserPageFragment


class UserAdapter(
    private val users: List<UserInfo>,
    private val context: Context
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = UserItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return UserViewHolder(binding, context)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        return holder.bind(users[position])
    }

    class UserViewHolder(private val binding: UserItemBinding, private val context: Context) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(user: UserInfo) {
            binding.apply {
                userName.text = user.name
                val options = RequestOptions()
                Glide
                    .with(binding.root)
                    .load(user.pictureSmall)
                    .apply(options.optionalCircleCrop())
                    .error(R.drawable.ic_baseline_photo_camera_24)
                    .into(userPhoto)
                root.setOnClickListener {
                    val activity: AppCompatActivity = itemView.context as AppCompatActivity
                    val transaction = activity.supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.container, UserPageFragment(user))
                    transaction.addToBackStack(null)
                    transaction.commit()
                }
                callUser.setOnClickListener {
                    val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + user.phone))
                    startActivity(context, intent, null)
                }
                emailUser.setOnClickListener {
                    val intent = Intent(Intent.ACTION_SENDTO)
                    intent.putExtra(Intent.EXTRA_SUBJECT, "Subject of email")
                    intent.putExtra(Intent.EXTRA_TEXT, "Body of email")
                    intent.data =
                        Uri.parse("mailto:" + user.email)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(context,intent, null)
                }
            }

        }
    }
}


