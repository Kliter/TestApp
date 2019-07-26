package com.example.testapp.main

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class DaggerApplication: Application(), HasActivityInjector {

    companion object {
        private const val TAG = "DaggerApplication"
    }

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingAndroidInjector

    override fun onCreate() {
        super.onCreate()
        val component = DaggerAppComponent.factory().create(this)
        component.inject(this)

        /**
         * Componentは複数作れないので注意！！
         */
//        val daggerPart5Component = DaggerDaggerPart5Component.factory().create(this)
//        daggerPart5Component.inject(this)
    }
}