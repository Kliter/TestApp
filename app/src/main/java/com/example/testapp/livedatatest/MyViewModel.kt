package com.example.testapp.livedatatest

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel: ViewModel() {

    // Create a LiveData with a String.
    val currentName: MutableLiveData<String> by lazy {
            MutableLiveData<String>()
    }

    // Rest of the ViewModel...
}