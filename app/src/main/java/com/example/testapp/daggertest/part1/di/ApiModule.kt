package com.example.testapp.daggertest.part1.di

import com.example.testapp.daggertest.common.ApiService
import com.example.testapp.daggertest.common.IApiService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Singleton
@Module
class ApiModule {

    /**
     * Injectするものを返すメソッドを用意する。
     * このメソッドから、対応するFactory(ApiModule_ProvideApiServiceFactory)が自動生成される。
     * DaggerAppComponentはApiModule_ProvideApiServiceFactoryを介して、
     * ApiModuleのprovideApiServiceを呼び出し、ApiServiceのインスタンスを取得する。
     */
    @Provides
    fun provideApiService(): IApiService {
        return ApiService()
    }
}