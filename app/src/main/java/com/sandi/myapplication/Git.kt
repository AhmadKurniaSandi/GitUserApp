package com.sandi.myapplication

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Git(
    var name: String,
    var username: String,
    var company: String,
    var photo: Int,
    var following: String,
    var follower: String,
    var repository: String
) : Parcelable
