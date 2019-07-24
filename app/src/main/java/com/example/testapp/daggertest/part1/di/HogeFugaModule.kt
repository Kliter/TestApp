package com.example.testapp.daggertest.part1.di

import com.example.testapp.daggertest.common.FugaService
import com.example.testapp.daggertest.common.HogeService
import com.example.testapp.daggertest.common.IFugaService
import com.example.testapp.daggertest.common.IHogeService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class HogeFugaModule {

    @Provides
    fun provideHogeService(): IHogeService {
        return HogeService()
    }

    @Provides
    fun proviceFugaService(): IFugaService {
        return FugaService()
    }
}