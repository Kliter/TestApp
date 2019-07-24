package com.example.testapp.daggertest.common

import android.app.Activity
import android.app.Application
import com.example.testapp.daggertest.part1.di.ApiModule
import com.example.testapp.daggertest.part1.di.AppComponent
import com.example.testapp.daggertest.part1.di.DaggerAppComponent
import com.example.testapp.daggertest.part2.di.DaggerParentComponent
import com.example.testapp.daggertest.part2.di.ParentComponent
import com.example.testapp.daggertest.part2.di.ParentModule
import com.example.testapp.daggertest.part3.di.DaggerPart3Component
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class MyApplication: Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    /**
     * Androidでは、
     * ApplicationクラスでComponentを生成して保持しておくことが多い。
     * この形式にしておけば、必要な時にどこからでもComponentにアクセスできる。
     */
    lateinit var appComponent: AppComponent

    lateinit var parentComponent: ParentComponent

    lateinit var daggerPart3Component: DaggerPart3Component

    override fun onCreate() {
        super.onCreate()

        /**
         * AppComponentのインスタンスは、
         * 自動生成されるDaggerAppComponent.Builderを使って取得する。
         */
        appComponent = DaggerAppComponent
            .builder()
            .apiModule(ApiModule())
            .build()

        parentComponent = DaggerParentComponent
            .builder()
            .parentModule(ParentModule())
            .build()

    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingAndroidInjector
    }
}