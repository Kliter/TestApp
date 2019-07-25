package com.example.testapp.daggertest.part5.di.module

import androidx.lifecycle.ViewModel
import com.example.testapp.daggertest.part5.viewmodel.DaggerPart5ViewModel1
import com.example.testapp.daggertest.part5.viewmodel.DaggerPart5ViewModel2
import com.example.testapp.daggertest.part5.viewmodel.DaggerPart5ViewModel3
import com.example.testapp.daggertest.part5.viewmodel.IDaggerPart5ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class DaggerPart5Module {

    /**
     * @IntoMap
     * Map形式でインスタンスを取得できる。
     * ViewModelはこの形式で取得するのが主流？
     */

    /**
     * @ViewModelKey
     * 自作アノテーション。
     * ViewModelを取得する際のキーを指定するため。
     */
    @Binds
    @IntoMap// Mapからインスタンスを取得するための宣言。
    @ViewModelKey(DaggerPart5ViewModel1::class)//このクラス名がキーになる。
    internal abstract fun provideDaggerPart5Model1(daggerPart5ViewModel1: DaggerPart5ViewModel1): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DaggerPart5ViewModel2::class)
    internal abstract fun provideDaggerPart5Model2(daggerPart5ViewModel2: DaggerPart5ViewModel2): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DaggerPart5ViewModel3::class)
    internal abstract fun provideDaggerpart5Model3(daggerPart5ViewModel3: DaggerPart5ViewModel3): ViewModel

}