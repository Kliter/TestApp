package com.example.testapp.retrofittest

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ItemService {
    @GET("items")// API URLから続くエンドポイントを、呼び出しメソッドとともに設定。
    fun items(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): Call<List<ItemEntity>>// List<ItemEntity>で結果を受け取るため、コールバックを設定している。
}