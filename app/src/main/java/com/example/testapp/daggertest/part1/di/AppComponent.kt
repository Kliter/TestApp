package com.example.testapp.daggertest.part1.di

import com.example.testapp.daggertest.common.IApiService
import com.example.testapp.daggertest.common.IFugaService
import com.example.testapp.daggertest.common.IHogeService
import com.example.testapp.daggertest.part1.ui.DaggerPart1Activity
import dagger.Component

@Component(
    modules = [
        ApiModule::class,
        HogeFugaModule::class
    ]
)
interface AppComponent {

    /**
     * ComponentにInjectされる側(ここだとDaggerPart1Activity)を引数にとる、返り値なしのメソッドを定義すると、
     * 引数に設定した側で@Injectを記述することで、フィールドにインジェクションできるようになる。
     */
    fun inject(target: DaggerPart1Activity)

    fun injectApiService(): IApiService
    fun injectHogeService(): IHogeService
    fun injectFugaService(): IFugaService
}