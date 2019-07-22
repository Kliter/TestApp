package com.example.testapp.databindingxlivedatasample

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel(), View.OnClickListener {

    var text: MutableLiveData<String> = MutableLiveData()
    private var count = 0

    override fun onClick(view: View) {
        count++
        text.value = "count: $count"
    }
}