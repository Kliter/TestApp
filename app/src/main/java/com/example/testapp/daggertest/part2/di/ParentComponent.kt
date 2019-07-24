package com.example.testapp.daggertest.part2.di

import com.example.testapp.daggertest.common.IHogeService
import com.example.testapp.daggertest.part2.view.DaggerPart2Activity
import dagger.Component

@Component(
    modules = [
        ParentModule::class
    ]
)
interface ParentComponent {

    fun inject(target: DaggerPart2Activity)

    // なぜかわからないけど、個別のInjectメソッドを定義するとDeprecatedが消える。
    fun injectHogeService(): IHogeService

    /**
     * 親Componentでは、
     * @Subcomponent.BuilderがついたBuilderを返すメソッドを用意することができる。
     * これをビルドすると、自動生成されるDaggerXXXComponentにはSubcomponentを実装したSubcomponentImplや、
     * Subcomponent.Builderを実装したSubcomponentBuilderが生成される。
     */
    fun subComponentBuilder(): SubComponent.Builder

    fun daggerPart2SubComponentBuilder(): DaggerPart2SubComponent.Builder

}