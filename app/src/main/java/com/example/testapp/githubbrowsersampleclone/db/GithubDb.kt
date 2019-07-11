package com.example.testapp.githubbrowsersampleclone.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.testapp.githubbrowsersampleclone.vo.Contributor
import com.example.testapp.githubbrowsersampleclone.vo.Repo
import com.example.testapp.githubbrowsersampleclone.vo.RepoSearchResult
import com.example.testapp.githubbrowsersampleclone.vo.User

/**
 * Main database description.
 */
@Database(
    entities = [
        User::class,
        Repo::class,
        Contributor::class,
        RepoSearchResult::class
    ],
    version = 3,
    exportSchema = false
)
abstract class GithubDb: RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun repoDao(): RepoDao
}