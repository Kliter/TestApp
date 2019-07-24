package com.example.testapp.daggertest.part3

import android.app.Activity
import android.app.Application
import com.example.testapp.daggertest.part3.di.DaggerDaggerPart3Component
import com.example.testapp.daggertest.part3.di.DaggerPart3Component
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * HasActivityInjector
 *
 */
class Application: Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingAndroidInjector

    override fun onCreate() {
        super.onCreate()

        // Daggerが自動生成したクラス.builder()を使用すること！
        /**
         * DaggerPart3Componentで指定した@BindsInstanceのメソッドを使って、
         * ApplicationクラスをModuleで利用できるようにしている(application(this)の部分)。
         */
        val objectGraph = DaggerDaggerPart3Component
            .builder()
            .application(this)
            .build()
        objectGraph.inject(this)
    }
}