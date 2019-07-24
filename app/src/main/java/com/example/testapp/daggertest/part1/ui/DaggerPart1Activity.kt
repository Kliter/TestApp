package com.example.testapp.daggertest.part1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testapp.R
import com.example.testapp.daggertest.common.IApiService
import com.example.testapp.daggertest.common.IFugaService
import com.example.testapp.daggertest.common.IHogeService
import javax.inject.Inject

/**
 * interface IApiService { }
 * 上記のようなAPIアクセスのためのinterfaceがあったとして、
 * Activityではその存在を意識したくない。
 * ApiServiceをどうインスタンス化するかはActivityの責務ではない。
 * インスタンスを内部で生成するのではなく、外部から注入したい。
 */

/**
 * インスタンスを外部から注入することのメリット
 * 1. テストなど、状況に応じて注入するインスタンスを切り替えられる。
 * 2. インスタンス化の方法が変わっても、利用側は影響を受けない。
 */

/**
 * 外部からインスタンスを注入する最も簡単なやり方は、コンストラクタで渡すこと。
 * しかし、Activityはフレームワークが生成するため、コンストラクタでは渡せない...。
 */

/**
 * 下記のような実装にはできない。
 */
//class DaggerActivity(
//    val serviceI: IApiService
//) : AppCompatActivity() {}

/**
 * そこで、インスタンス化を責務とするクラス(Factoryなど)を用意して、
 * Activityからはそれをつかってインスタンスを取得するようにしてみる。
 */
//利用側
//serviceI = apiServiceFactory.create()

//Factory
//class ApiServiceFactory {
//    companion object {
//        private var serviceI: IApiService
//        create() {
//            if (serviceI == null) {
//                val retrofit: ApiService = ...
//                return retrofit.create(IApiService::class)
//            }
//            return serviceI
//        }
//    }
//}

/**
 * このやり方だと2つの大きな欠点がある。
 * 1. 外部から注入したいクラスごとに同じようなFactoryクラスが必要。
 * 2. どのFactoryを使うかをActivityが知っていないといけない。
 * Daggerはこの辺りの問題を解決してくれる。
 */

/**
 * Daggerの主な構成要素は下記の2つ。
 * 1. Component
 *      Injectorの役割を持つ。
 *      Injectされる側は、Componentを経由して必要なインスタンスをもらう。
 *      どこにInjectするかを記述する。
 * 2. Module
 *      インスタンスを生成する。
 *      Injectするインスタンスをどう生成するかを定義する。
 */

class DaggerPart1Activity : AppCompatActivity() {

    // 自分でインジェクションする場合はフィールドを定義しておく。
//    private lateinit var serviceI: IApiService
//    private lateinit var hogeService: IHogeService
//    private lateinit var fugaService: IFugaService

    /**
     * フィールドインジェクションを使う場合は、privateにしないように！
     */
    @Inject
    lateinit var serviceI: IApiService
    @Inject
    lateinit var hogeService: IHogeService
    @Inject
    lateinit var fugaService: IFugaService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dagger_part1)

        /**
         * 自分でフィールドにインジェクションしていくと、だんだん冗長になってくる...。
         * →代入部分もDaggerに任せよう！
         */
//        serviceI = (application as MyApplication).appComponent.injectApiService()
//        hogeService = (application as MyApplication).appComponent.injectHogeService()
//        fugaService = (application as MyApplication).appComponent.injectFugaService()


    }
}
