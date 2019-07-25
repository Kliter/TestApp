package com.example.testapp.daggertest.part4.di

import com.example.testapp.daggertest.part4.ui.DaggerPart4Activity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class DaggerPart4ActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeDaggerPart4Activity(): DaggerPart4Activity

    /**
     * 下のようにInject先のActivityを追加していく。
     * @ContributesAndroidInjector
     * internal abstract fun bindMainActivity(): MainActivity
     */
}