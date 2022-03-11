package com.dicoding.picodiploma.githubuserapps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailUser : AppCompatActivity() {
    companion object {
        const val EXTRA_USER = "extra_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_user)

        val tvAvatar: ImageView = findViewById(R.id.img_profile_detail)
        val tvUsername: TextView = findViewById(R.id.id_username_detail)
        val tvName: TextView = findViewById(R.id.full_name_detail)
        val tvFollowers: TextView = findViewById(R.id.followers)
        val tvFollowing: TextView = findViewById(R.id.following_detail)
        val tvRepository: TextView = findViewById(R.id.repository)
        val tvCompany: TextView = findViewById(R.id.company_detail)
        val tvLocation: TextView = findViewById(R.id.location)


        val user = intent.getParcelableExtra<User>(EXTRA_USER) as User
        Glide.with(this)
            .load(user.avatar)
            .apply(RequestOptions())
            .into(tvAvatar)

        tvUsername.text = user.username
        tvName.text = user.fullName
        tvFollowers.text = user.followers
        tvCompany.text = user.following
        tvFollowing.text = user.company
        tvLocation.text = user.location
        tvRepository.text = user.repository
    }
}