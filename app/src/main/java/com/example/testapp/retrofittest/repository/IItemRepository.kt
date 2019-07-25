package com.example.testapp.retrofittest.repository

import com.example.testapp.retrofittest.model.ItemEntity

interface IItemRepository {

    fun getItemList(callback: (List<ItemEntity>) -> Unit)

}