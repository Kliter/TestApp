package com.example.testapp.retrofittest.di.module

import androidx.lifecycle.ViewModel
import com.example.testapp.retrofittest.viewmodel.RetrofitViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(RetrofitViewModel::class)
    internal abstract fun provideRetrofitViewModel(retrofitViewModel: RetrofitViewModel): ViewModel

//    @Binds
//    internal abstract fun provideRetrofitViewModel(retrofitViewModel: RetrofitViewModel): ViewModel
}