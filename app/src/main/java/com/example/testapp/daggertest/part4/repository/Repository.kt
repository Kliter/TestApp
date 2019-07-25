package com.example.testapp.daggertest.part4.repository

import javax.inject.Inject

//Injectされるクラスのコンストラクタには、@Injectをつけること。
class Repository @Inject constructor(): IRepository {

    lateinit var name: String

    constructor(name: String): this() {
        this.name = name
    }
}