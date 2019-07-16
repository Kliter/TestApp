package com.example.testapp.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.testapp.R
import com.example.testapp.databinding.ActivityMainBinding
import com.example.testapp.databindingtest.view.DataBindingActivity
import com.example.testapp.enumtest.EnumActivity
import com.example.testapp.kointest.view.KoinActivity
import kotlinx.android.synthetic.main.activity_main.*

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
            R.id.btn_enum_test -> {
                intent.setClass(this, EnumActivity::class.java)
            }
        }
        startActivity(intent)
    }
}
