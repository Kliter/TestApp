package com.example.testapp.daggertest.part4.di

import com.example.testapp.daggertest.part4.repository.IRepository
import com.example.testapp.daggertest.part4.repository.Repository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideRepository(): IRepository {
        return Repository("KL")
    }

}