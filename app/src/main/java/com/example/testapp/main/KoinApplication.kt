package com.example.testapp.main

import android.app.Application
import com.example.testapp.databindingtest.model.User
import com.example.testapp.kointest.model.GreetingRepository
import com.example.testapp.kointest.viewmodel.MainViewModel
import org.koin.android.ext.android.startKoin
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

class KoinApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        // Create DI container.
        startKoin(this, listOf(
            this.module
        ))
    }

    // Koin Module
    private val module: Module = module {
        factory { User("KL") }
        factory { GreetingRepository() }
        factory { MainViewModel(get()) }
    }
}