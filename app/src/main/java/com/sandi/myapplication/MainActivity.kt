package com.sandi.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvGit: RecyclerView
    private val list = ArrayList<Git>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvGit = findViewById(R.id.rv_git)
        rvGit.setHasFixedSize(true)

        list.addAll(listGit)
        showRecyclerList()
    }

    private val listGit: ArrayList<Git>
        get() {
            val name = resources.getStringArray(R.array.name)
            val username = resources.getStringArray(R.array.username)
            val company = resources.getStringArray(R.array.company)
            val photo = resources.obtainTypedArray(R.array.avatar)
            val following = resources.getStringArray(R.array.following)
            val follower = resources.getStringArray(R.array.followers)
            val repository = resources.getStringArray(R.array.repository)

            val listGit = ArrayList<Git>()
            for(i in name.indices){
                val user = Git(name[i], username[i], company[i], photo.getResourceId(i, -1),
                    following[i], follower[i], repository[i])
                listGit.add(user)
            }
            return listGit
        }
    private fun showRecyclerList(){
        rvGit.layoutManager = LinearLayoutManager(this)
        val listGitAdapter = ListGitAdapter(list)
        rvGit.adapter = listGitAdapter

        listGitAdapter.setOnItemClick(object: ListGitAdapter.OnItemClick {
            override fun onItemClicked(data: Git) {
                val intentActivity = Intent(this@MainActivity, MainActivity2::class.java)
                intentActivity.putExtra(MainActivity2.EXTRA_GIT, data)
                startActivity(intentActivity)
            }
        })
    }

}