package com.example.testapp.daggertest.part4.repository

class Repository(): IRepository {

    lateinit var name: String

    constructor(name: String): this() {
        this.name = name
    }
}