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
        binding.lifecycleOwner = this // これがあることで、Activityがactiveな時にのみ更新されるようになる。
        binding.retrofitViewmodel = viewModel // 監視の機能はViewModelが提供する。
        viewModel.getItems()
    }
}
