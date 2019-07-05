package com.example.testapp.kointest.viewmodel

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.testapp.BR
import com.example.testapp.kointest.model.GreetingRepository

class MainViewModel(private val greetingRepository: GreetingRepository): BaseObservable() {

    @get:Bindable
    var currentText: String? = "Hello"
        set(value) {
            field = value
            notifyPropertyChanged(BR.currentText)
        }

    fun greet() {
        //currentText = "Hello Koin!"
        currentText = greetingRepository.greet()
    }
}