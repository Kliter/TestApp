package com.example.testapp.githubbrowsersampleclone.di

import android.app.Application
import com.example.testapp.githubbrowsersampleclone.GithubApp
import com.example.testapp.githubbrowsersampleclone.GithubBrowserSampleCloneActivity
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        GithubBrowserSampleCloneActivity::class]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(githubApp: GithubApp)
}
