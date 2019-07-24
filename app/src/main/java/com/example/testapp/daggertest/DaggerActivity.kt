package com.example.testapp.daggertest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.testapp.R
import com.example.testapp.daggertest.part1.ui.DaggerPart1Activity
import com.example.testapp.daggertest.part2.view.DaggerPart2Activity
import com.example.testapp.daggertest.part3.ui.DaggerPart3Activity
import com.example.testapp.databinding.ActivityDaggerBinding

// http://y-anz-m.blogspot.com/2017/07/android-dagger-1.html

class DaggerActivity : AppCompatActivity(),View.OnClickListener {

    companion object {
        private const val TAG = "DaggerActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityDaggerBinding>(this, R.layout.activity_dagger)
        binding.handler = this
    }

    override fun onClick(view: View?) {
        val intent = Intent()
        when (view?.id) {
            R.id.btn_dagger_part1 -> {
                intent.setClass(this, DaggerPart1Activity::class.java)
            }
            R.id.btn_dagger_part2 -> {
                intent.setClass(this, DaggerPart2Activity::class.java)
            }
            R.id.btn_dagger_part3 -> {
                intent.setClass(this, DaggerPart3Activity::class.java)
            }
        }
        startActivity(intent)
    }
}
