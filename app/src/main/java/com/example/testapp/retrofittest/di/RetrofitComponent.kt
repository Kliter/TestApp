package com.example.testapp.retrofittest.di

import com.example.testapp.main.DaggerApplication
import com.example.testapp.retrofittest.ui.RetrofitActivity
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@Component(
    modules = [
        AndroidInjectionModule::class,
        RetrofitActivityModule::class,
        ViewModelModule::class
    ]
)
interface RetrofitComponent: AndroidInjector<RetrofitActivityModule> {

    fun inject(target: DaggerApplication)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance
            app: DaggerApplication
        ): RetrofitComponent
    }
}