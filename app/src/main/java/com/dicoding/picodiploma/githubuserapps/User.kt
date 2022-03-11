package com.dicoding.picodiploma.githubuserapps

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    var username: String?,
    var fullName: String?,
    var location: String?,
    var repository: String?,
    var company: String?,
    var followers: String?,
    var following: String?,
    var avatar: Int?


) : Parcelable