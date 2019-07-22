package com.example.testapp.enumtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.testapp.R
import com.example.testapp.databinding.ActivityDataBindingxLiveDataBinding
import com.example.testapp.databindingxlivedatasample.MainViewModel

//https://qiita.com/taki4227/items/34f0acddc97f1b9a52b8

class DataBindingxLiveDataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityDataBindingxLiveDataBinding>(this, R.layout.activity_data_bindingx_live_data)

        val viewModel = MainViewModel()
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
    }
}
