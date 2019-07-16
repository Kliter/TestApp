package com.example.testapp.enumtest

enum class TestEnum(val number: Int, val nameText: String) {
    /**
     * これらの列挙子は、TestEnumにぶら下がったオブジェクトであり、定数。
     * 型はTestEnumなので、コンストラクタの第一引数にInt、第二引数にStringを指定している。
     */
    AAA(2, "aaa"),
    BBB(4, "bbb"),
    CCC(6, "ccc")
}