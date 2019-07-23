package com.example.testapp.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.testapp.R
import com.example.testapp.daggertest.DaggerActivity
import com.example.testapp.databinding.ActivityMainBinding
import com.example.testapp.databindingtest.view.DataBindingActivity
import com.example.testapp.databindingxlivedatasample.DataBindingxLiveDataActivity
import com.example.testapp.epoxytest.EpoxyActivity
import com.example.testapp.kointest.view.KoinActivity
import com.example.testapp.retrofittest.RetrofitActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.handler = this
    }

    override fun onClick(view: View?) {
        val intent = Intent()
        when (view?.id) {
            R.id.btn_databinding_test -> {
                intent.setClass(this, DataBindingActivity::class.java)
            }
            R.id.btn_koin_test -> {
                intent.setClass(this, KoinActivity::class.java)
            }
            R.id.btn_live_data_test -> {
                intent.setClass(this, KoinActivity::class.java)
            }
            R.id.btn_enum_test -> {
                intent.setClass(this, KoinActivity::class.java)
            }
            R.id.btn_epoxy_test -> {
                intent.setClass(this, EpoxyActivity::class.java)
            }
            R.id.btn_retrofit_test -> {
                intent.setClass(this, RetrofitActivity::class.java)
            }
            R.id.btn_databindingxlivedata_sample -> {
                intent.setClass(this, DataBindingxLiveDataActivity::class.java)
            }
            R.id.btn_dagger_test -> {
                intent.setClass(this, DaggerActivity::class.java)
            }
        }
        startActivity(intent)
    }
}
