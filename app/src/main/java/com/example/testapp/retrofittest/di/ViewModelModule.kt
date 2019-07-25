package com.example.testapp.retrofittest.di

import com.example.testapp.retrofittest.viewmodel.RetrofitViewModel
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {

    @Provides
    fun provideRetrofitViewModel(): RetrofitViewModel {
        return RetrofitViewModel()
    }

}