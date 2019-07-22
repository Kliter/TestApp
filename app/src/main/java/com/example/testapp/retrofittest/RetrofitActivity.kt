package com.example.testapp.retrofittest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.testapp.R
import com.example.testapp.databinding.ActivityRetrofitBinding

class RetrofitActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "RetrofitActivity"
    }

    private lateinit var mRetrofitViewModel: RetrofitViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mRetrofitViewModel = RetrofitViewModel()

        val binding = DataBindingUtil.setContentView<ActivityRetrofitBinding>(this, R.layout.activity_retrofit)
        binding.retrofitViewmodel = mRetrofitViewModel

        val itemRepository = ItemRepository()
        itemRepository.getItemList { itemList ->
            Log.d(TAG, "$itemList")
            mRetrofitViewModel.result = itemList.joinToString()
        }
    }
}
