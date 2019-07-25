package com.example.testapp.retrofittest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.testapp.R
import com.example.testapp.databinding.ActivityRetrofitBinding
import com.example.testapp.retrofittest.viewmodel.RetrofitViewModel
import com.example.testapp.retrofittest.viewmodel.ViewModelFactory
import dagger.android.AndroidInjection
import javax.inject.Inject

class RetrofitActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "RetrofitActivity"
    }

//    @Inject
//    lateinit var viewModelFactory: ViewModelFactory
    @Inject
    lateinit var viewModel: RetrofitViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityRetrofitBinding>(this, R.layout.activity_retrofit)
//        viewModel = ViewModelProviders.of(this, viewModelFactory).get(RetrofitViewModel::class.java)

        binding.lifecycleOwner = this // これがあることで、Activityがactiveな時にのみ更新されるようになる。
        binding.retrofitViewmodel = viewModel // 監視の機能はViewModelが提供する。
        viewModel.getItems()
    }
}
