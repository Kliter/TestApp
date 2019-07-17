package com.example.testapp.githubbrowsersampleclone.vo

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(primaryKeys = ["login"])// プライマリキーを指定している。
data class User(
    @field:SerializedName("login")// Jsonにパースした時に指定した名前になる。
    val login: String,
    @field:SerializedName("avatar_url")
    val avatarUrl: String?,
    @field:SerializedName("name")
    val name: String?,
    @field:SerializedName("company")
    val company: String?,
    @field:SerializedName("repos_url")
    val reposUrl: String?,
    @field:SerializedName("blog")
    val blog: String?
)