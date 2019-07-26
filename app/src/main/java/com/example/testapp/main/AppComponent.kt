package com.example.testapp.main

import com.example.testapp.retrofittest.di.module.RetrofitActivityModule
import com.example.testapp.retrofittest.di.module.ViewModelModule
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
interface AppComponent: AndroidInjector<DaggerApplication> {

    override fun inject(app: DaggerApplication)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance
            app: DaggerApplication
        ): AppComponent
    }
}