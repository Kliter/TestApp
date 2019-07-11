package com.example.testapp.githubbrowsersampleclone.di

import com.example.testapp.githubbrowsersampleclone.GithubApp
import javax.inject.Singleton

/**
 * Helper class to automatically inject fragments if they implement [Injectable]
 */
object AppInjector {
    fun init (githubApp: GithubApp) {
//        DaggerAppComponent.builder().application(githubApp)
    }
}