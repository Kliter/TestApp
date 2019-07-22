package com.example.testapp.retrofittest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.testapp.R
import com.example.testapp.databinding.ActivityRetrofitBinding

class RetrofitActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "RetrofitActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityRetrofitBinding>(this, R.layout.activity_retrofit)

        val viewModel = RetrofitViewModel()
        binding.lifecycleOwner = this
        binding.retrofitViewmodel = viewModel
        viewModel.getItems()
    }
}
