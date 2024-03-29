package com.example.testapp.retrofittest.di.module

import com.example.testapp.retrofittest.ui.RetrofitActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class RetrofitActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeRetrofitActivity(): RetrofitActivity

}