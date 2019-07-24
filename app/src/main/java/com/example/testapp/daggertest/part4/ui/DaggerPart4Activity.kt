package com.example.testapp.daggertest.part4.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.testapp.R
import com.example.testapp.daggertest.part4.repository.IRepository
import dagger.android.AndroidInjection
import javax.inject.Inject

class DaggerPart4Activity : AppCompatActivity() {

    companion object {
        private const val TAG = "DaggerPart4Activity"
    }

    @Inject
    lateinit var repository: IRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dagger_part4)

        if (repository != null) {
            Log.d(TAG, "Repository Name: ${repository}")
            Log.d(TAG, "Injection Succeed!! Congratulations!!")
        }
    }
}
