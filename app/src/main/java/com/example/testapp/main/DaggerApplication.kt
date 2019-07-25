package com.example.testapp.main

import android.app.Activity
import android.app.Application
import com.example.testapp.retrofittest.di.DaggerRetrofitComponent
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
        val component = DaggerRetrofitComponent.factory().create(this)
        component.inject(this)
    }
}