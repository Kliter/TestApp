package com.example.testapp.databindingtest.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.testapp.BR


class User(): BaseObservable() {

    constructor(name: String?): this() {
        this.name = name
    }

    // 1.Create variables with @Bindable.
    // 2.Execute project clean and build.
    // 3.Created BR.property.
    @get:Bindable
    var name: String? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.name)
        }
}