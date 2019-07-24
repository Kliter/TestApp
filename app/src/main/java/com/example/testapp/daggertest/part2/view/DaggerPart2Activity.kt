package com.example.testapp.daggertest.part2.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testapp.R
import com.example.testapp.daggertest.common.MyApplication

/**
 * subcomponentとは？
 * 親(parent)Componentのobject graphを継承し、拡張するためのcomponent
 *
 * subcomponentはなんのために使うの？
 * アプリケーションのobject graphをsubgraphに分けるために使う。
 *
 * subgraphに分けるのはなんのため？
 * 1. アプリケーションの様々な部分を互いに隔離(カプセル化)するため。
 * 2. コンポーネント内で複数のスコープを使うため。
 */

class DaggerPart2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dagger_part2)

        /**
         * あとは@Injectを持ったフィールドを用意しておくだけでインジェクションされる。
         */
        (application as MyApplication).parentComponent.subComponentBuilder().build().inject(this)
        (application as MyApplication).parentComponent.daggerPart2SubComponentBuilder().build().inject(this)
    }
}
