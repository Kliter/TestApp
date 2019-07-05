package com.example.testapp.kointest.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.testapp.R
import com.example.testapp.databinding.ActivityKoinBinding
import com.example.testapp.databinding.ActivityMainBinding
import com.example.testapp.kointest.viewmodel.MainViewModel
import org.koin.android.ext.android.inject

class KoinActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        private const val TAG = "KoinActivity"
    }

    private val mViewModel: MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityKoinBinding>(this, R.layout.activity_koin)
        binding.viewModel = mViewModel
        binding.handler = this
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btn_greeting -> {
                mViewModel.greet()
            }
        }
    }
}
