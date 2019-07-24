package com.example.testapp.daggertest.part4.di

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@Component(
    modules = [
        AndroidInjectionModule::class,
        DaggerPart4ActivityModule::class,
        RepositoryModule::class
    ]
)
interface DaggerPart4Component: AndroidInjector<DaggerPart4ActivityModule> {

    fun inject(application: DaggerPart4Application)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance
            app: DaggerPart4Application
        ): DaggerPart4Component
    }
}