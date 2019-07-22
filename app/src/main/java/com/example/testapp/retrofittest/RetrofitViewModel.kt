package com.example.testapp.retrofittest

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.testapp.BR

class RetrofitViewModel: BaseObservable() {

    @get: Bindable
    var result: String? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.result)
        }
}