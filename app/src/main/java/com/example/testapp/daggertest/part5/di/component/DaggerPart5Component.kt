package com.example.testapp.daggertest.part5.di.component

import com.example.testapp.daggertest.part5.di.module.DaggerPart5ActivityModule
import com.example.testapp.daggertest.part5.di.module.DaggerPart5Module
import com.example.testapp.main.DaggerApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@Component(
    modules = [
        AndroidInjectionModule::class,
        DaggerPart5ActivityModule::class,
        DaggerPart5Module::class
    ]
)
interface DaggerPart5Component: AndroidInjector<DaggerApplication> {

    override fun inject(application: DaggerApplication)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance
            app: DaggerApplication
        ): DaggerPart5Component
    }
}