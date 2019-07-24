package com.example.testapp.daggertest.part2.di

import com.example.testapp.daggertest.common.HogeService
import com.example.testapp.daggertest.common.IHogeService
import dagger.Module
import dagger.Provides

/**
 * subcomponentを親のcomponentに追加するには、
 * 親のcomponentが取り込むModuleの@Moduleアノテーションに、
 * subcomponents属性で指定する。
 *
 * ※注意事項
 * "subcomponent"という名前につられて、@Componentに追加しないようにする！
 */
@Module(
    subcomponents = [
        SubComponent::class,
        DaggerPart2SubComponent::class
    ]
)
class ParentModule {

    @Provides
    fun provideHogeService(): IHogeService {
        return HogeService()
    }

}