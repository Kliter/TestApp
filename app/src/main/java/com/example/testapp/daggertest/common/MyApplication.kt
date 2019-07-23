package com.example.testapp.daggertest.common

import android.app.Application
import com.example.testapp.daggertest.part1.di.ApiModule
import com.example.testapp.daggertest.part1.di.AppComponent
import com.example.testapp.daggertest.part1.DaggerAppComponent

class MyApplication: Application() {

    /**
     * Androidでは、
     * ApplicationクラスでComponentを生成して保持しておくことが多い。
     * この形式にしておけば、必要な時にどこからでもComponentにアクセスできる。
     */
    lateinit var appComponent: AppComponent

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
    }
}