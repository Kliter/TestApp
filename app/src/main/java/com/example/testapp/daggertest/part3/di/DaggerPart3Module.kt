package com.example.testapp.daggertest.part3.di

import com.example.testapp.daggertest.part3.ui.DaggerPart3Activity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class DaggerPart3Module {

    /**
     * @ContributesAndroidInjector
     * 2.11から新たに追加されたAPI。
     * 2.10まで自分で記述していたコードを自動生成してくれる。
     * 基本的に、これを持つModuleはこの関数のみ持つ。
     * Activityを返すことになるので、XXXActivityModuleという命名になりそう。
     */
    @ContributesAndroidInjector
    abstract fun contributeDaggerPart3Activity(): DaggerPart3Activity

}