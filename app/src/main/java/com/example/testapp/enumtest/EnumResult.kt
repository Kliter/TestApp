package com.example.testapp.enumtest

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.testapp.BR

class EnumResult: BaseObservable() {

    @get:Bindable
    var enumName: String? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.enumName)
        }
}