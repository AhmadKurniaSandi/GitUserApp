package com.sandi.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    companion object{
        const val EXTRA_GIT = "extra_git"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val Detailusername:TextView = findViewById(R.id.tv_username)
        val Detailname: TextView = findViewById(R.id.detail_name)
        val DetailFollowing: TextView = findViewById(R.id.tv_following)
        val DetailFollower: TextView = findViewById(R.id.tv_follower)
        val DetailRepository: TextView = findViewById(R.id.tv_repo)
        val DetailAvatar: ImageView = findViewById(R.id.imageView2)

        val gitUser = intent.getParcelableExtra<Git>(EXTRA_GIT) as Git

        Detailname.text=gitUser.name
        Detailusername.text=gitUser.username
        DetailFollowing.text=gitUser.following
        DetailFollower.text=gitUser.follower
        DetailRepository.text=gitUser.repository
        DetailAvatar.setImageResource(gitUser.photo)
    }

}