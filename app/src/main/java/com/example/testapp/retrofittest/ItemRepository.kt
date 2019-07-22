package com.example.testapp.retrofittest

import android.util.Log
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ItemRepository {

    companion object {
        private const val TAG = "ItemRepository"
    }

    private var itemService: ItemService

    init {
        val okHttpClient = OkHttpClient.Builder().build()                   // APIを呼び出すクライアントを作成する。
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build() // 結果をパースするためのmoshiをインスタンス化。
        val retrofit = Retrofit.Builder()                                   // API URLを設定。(エンドポイントは各インターフェース側で設定する。)
            .baseUrl("https://qiita.com/api/v2/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(okHttpClient)
            .build()
        itemService = retrofit.create(ItemService::class.java)              // itemServiceを通してAPI呼び出しできるようにする。
    }

    fun getItemList(callback: (List<ItemEntity>) -> Unit) {
        itemService.items(page = 1, perPage = 10).enqueue(object: Callback<List<ItemEntity>> {
            override fun onFailure(call: Call<List<ItemEntity>>, t: Throwable) {
                Log.e(TAG, "API call failed.")
            }

            override fun onResponse(call: Call<List<ItemEntity>>, response: Response<List<ItemEntity>>?) {
                response?.let { // responseがnullじゃない時だけlet内が実行される。
                    if (response.isSuccessful) {
                        Log.d(TAG, "API call succeed.")

                        response.body()?.let { list ->
                            callback(list)
                        }
                    }
                }
            }
        })
    }
}