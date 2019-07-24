package com.example.testapp.daggertest.part3.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testapp.R
import dagger.android.AndroidInjection
import javax.inject.Inject

//https://medium.com/@star_zero/dagger-android%E6%8B%A1%E5%BC%B5%E3%81%AE%E4%BD%BF%E3%81%84%E6%96%B9-6527dcb74531
/**
 * ActivityやFragmentのインスタンスは、Androidフレームワークによって生成されるため、
 * ライフサイクルメソッドでinjectする処理を明示的に行う必要がある。
 */
class DaggerPart3Activity : AppCompatActivity() {

    companion object {
        private const val TAG = "DaggerPart3Activity"
    }

    /**
     * @Inject
     * lateinit var service: GitHubService
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        /**
         * DaggerのAndroidサポートのおかげで、
         * AndroidInjection.inject(this)
         * だけでDIされるようになった。
         *
         * 【処理内容】
         * ApplicationクラスでHasActivityInjectorが実装されていれば、
         * DispatchingAndroidInjectorを使って引数のActivityをComponent(別名ObjectGraph)に入れる。
         * Activityで@InjectしているフィールドにInjectしてくれる。
         * Componentを取得する処理をActivityから消すっていう意識が大事！そのための処理。
         */
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dagger_part3)

        /**
         * こんな感じで。
         * (application as MyApplication).appComponent...
         *     .inject(this)
         */

        /**
         * けど、本来これはあまり良くない実装。
         * 理由は二つ。
         * 1. 各ActivityやFragmentでこの処理を書くため、コピー&ペーストが多用されることになる。
         *      コピペされたコードは後々リファクタリングするのが大変になり、技術的負債になりうる。
         *      皆がコピペに頼ると、何をしているのかわかる人が限られてしまう。
         * 2. Activityがinjectorについて知っている必要がある。
         *      実際の型ではなくinterfaceを通してinjectされるとしても、「どのようにinjectされるのかを知っているべきではない」という
         *      Dependency Injectionの原則に則っていない。
         *
         * ★この二つの問題を解決するために、Android用のライブラリが別途用意されている。
         * ※そもそもDaggerはAndroid専用に作られたライブラリではない。
         */
    }
}
