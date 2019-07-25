package com.example.testapp.retrofittest.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testapp.retrofittest.repository.ItemRepository
import javax.inject.Inject

class RetrofitViewModel @Inject constructor(): ViewModel(), IRetrofitViewModel {

    companion object {
        private const val TAG = "RetrofitViewModel"
    }

    var result: MutableLiveData<String> = MutableLiveData()

    override fun getItems() {
        val itemRepository = ItemRepository()
        itemRepository.getItemList { itemList ->
            Log.d(TAG, "$itemList")
            this.result.value = itemList.joinToString()
        }
    }
}