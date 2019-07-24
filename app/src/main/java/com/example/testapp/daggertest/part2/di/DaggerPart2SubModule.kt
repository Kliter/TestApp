package com.example.testapp.daggertest.part2.di

import com.example.testapp.daggertest.common.HogeService
import com.example.testapp.daggertest.common.IHogeService
import dagger.Module
import dagger.Provides

@Module
class DaggerPart2SubModule {

    @Provides
    fun provideHogeService(): IHogeService {
        return HogeService()
    }

}