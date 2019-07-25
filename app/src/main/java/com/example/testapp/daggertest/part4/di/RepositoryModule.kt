package com.example.testapp.daggertest.part4.di

import com.example.testapp.daggertest.part4.repository.IRepository
import com.example.testapp.daggertest.part4.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class RepositoryModule {


//    これは@Bindsで省略可能。
//    @Provides
//    fun provideRepository(): IRepository {
//        return Repository("KL")
//    }


    // Repositoryのコンストラクタに@Injectが付いていないと、コンパイルエラーになる。
    @Binds
    internal abstract fun provideRepository(repository: Repository): IRepository
}