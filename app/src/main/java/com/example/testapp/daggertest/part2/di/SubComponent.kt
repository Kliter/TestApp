package com.example.testapp.daggertest.part2.di

import com.example.testapp.daggertest.part2.view.DaggerPart2Activity
import dagger.Subcomponent

/**
 * subcomponentはinterfaceで用意する。
 */
@Subcomponent(modules = [SubComponentModule::class])
interface SubComponent {

    fun inject(target: DaggerPart2Activity)

    /**
     * subcomponentでは、
     * @Subcomponent.Builderをつけたinterfaceを用意しないと、
     * @Component→@DaggerAppComponentのような自動生成は行われない。
     */
    @Subcomponent.Builder
    interface Builder {
        /**
         * SubComponentインターフェースを生成するためのビルダーを返却するメソッドを定義する。
         */
        fun subComponentSpecificModule(module: SubComponentModule): Builder
        /**
         * builderにはsubcomponentを返すメソッドを用意する必要がある。
         */
        fun build(): SubComponent
    }
}