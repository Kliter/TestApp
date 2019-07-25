package com.example.testapp.retrofittest.model

import com.squareup.moshi.Json

data class ItemEntity(
    @Json(name="id")// 記事ID
    val id: String,
    @Json(name="title")// 記事タイトル
    val title: String,
    @Json(name="body")// 記事内容
    val body: String
)