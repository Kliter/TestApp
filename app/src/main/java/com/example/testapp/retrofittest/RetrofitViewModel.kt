package com.example.testapp.retrofittest

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RetrofitViewModel: ViewModel() {

    companion object {
        private const val TAG = "RetrofitViewModel"
    }

    var result: MutableLiveData<String> = MutableLiveData()

    fun getItems() {
        val itemRepository = ItemRepository()
        itemRepository.getItemList { itemList ->
            Log.d(TAG, "$itemList")
            this.result.value = itemList.joinToString()
        }
    }
}