package com.example.testapp.githubbrowsersampleclone.vo

import androidx.room.Entity
import androidx.room.TypeConverters
import com.example.testapp.githubbrowsersampleclone.db.GithubTypeConverters

@Entity(primaryKeys = ["query"])
@TypeConverters(GithubTypeConverters::class)// RoomはListを扱えないので、TypeConvertersを使用する。
data class RepoSearchResult (
    val query: String,
    val repoIds: List<Int>,
    val totalCount: Int,
    val next: Int
)