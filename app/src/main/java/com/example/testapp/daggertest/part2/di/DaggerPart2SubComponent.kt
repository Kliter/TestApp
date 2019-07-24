package com.example.testapp.daggertest.part2.di

import com.example.testapp.daggertest.part2.view.DaggerPart2Activity
import dagger.Subcomponent

@Subcomponent(modules = [DaggerPart2SubModule::class])
interface DaggerPart2SubComponent {

    fun inject(target: DaggerPart2Activity)

    @Subcomponent.Builder
    interface Builder {
        fun build(): DaggerPart2SubComponent
    }

}