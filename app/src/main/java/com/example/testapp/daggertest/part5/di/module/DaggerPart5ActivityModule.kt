package com.example.testapp.daggertest.part5.di.module

import com.example.testapp.daggertest.part5.ui.DaggerPart5Activity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class DaggerPart5ActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeDaggerPart5Activity(): DaggerPart5Activity

}