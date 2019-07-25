package com.example.testapp.daggertest.part5.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import com.example.testapp.R
import com.example.testapp.daggertest.part5.viewmodel.DaggerPart5ViewModel1
import com.example.testapp.daggertest.part5.viewmodel.DaggerPart5ViewModel2
import com.example.testapp.daggertest.part5.viewmodel.DaggerPart5ViewModel3
import com.example.testapp.daggertest.part5.viewmodel.ViewModelFactory
import dagger.android.AndroidInjection
import javax.inject.Inject

//https://qiita.com/superman9387/items/bea94e4316c2ccf8fb68
//https://qiita.com/satorufujiwara/items/f42b176404287690f1d0

/**
 * ViewModelをViewModelProviderから取得するように修正したい。
 */
class DaggerPart5Activity : AppCompatActivity() {

    companion object {
        private const val TAG = "DaggerPart5Activity"
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var daggerPart5ViewModel1: DaggerPart5ViewModel1
    private lateinit var daggerPart5ViewModel2: DaggerPart5ViewModel2
    private lateinit var daggerPart5ViewModel3: DaggerPart5ViewModel3

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dagger_part5)

        /**
         * val viewModel = ViewModelProviders.of(activity!!).get(MainViewModel::class.java)
         * 上記のようにViewModelのインスタンスを取得する場合、
         * ・ViewModelProviders::ofの引数から取得できるFragmentManagerが同一であれば、ViewModelのインスタンスの格納場所(ViewModelStore)が同一になる。
         * ・すなわち、異なるFragmentであっても同じActivity内にあって、ViewModelProviders::ofの引数にActivityを指定すれば同じ格納場所を取得できる。
         * ・格納場所からViewModelを取得する際、ViewModelProvider::getの引数のクラス名がキーになる。
         */

        /**
         * ViewModelProviders::ofの引数に一つしか指定しないと、下記の実装が適用される。
         * public static ViewModelProvider of (@NonNull FragmentActivity activity) {
         *     initializeFactoryIfNeeded(checkApplication(activity));
         *     return new ViewModelProvider(ViewModelStores.of(activity), sDefaultFactory);
         * }
         * sDefaultFactoryはViewModelProvider.Factoryを継承したクラス。
         * sDefaultFactoryを使用した場合、
         * ・AndroidViewModelを継承したViewModelの場合、コンストラクタに　Applicationクラスが引数として渡され、インスタンスが生成される。
         * ・上記ではないViewModelの場合、引数なしのコンストラクタが呼ばれ、インスタンスが生成される。
         *
         * したがって...。
         * ★下記のViewModelクラスのように、Applicationクラスイアギをコンストラクタの引数としたい場合は、DefaultFactoryではなく、独自のViewModelProvider.Factoryが必要になる。
         * class MainViewModel constructor( private val repository: GitHubRepository): ViewModel()
         *
         * 独自のViewModelProvider.Factoryを実装する手間を省くため、Daggerの機能を使って実装する。
         */

        daggerPart5ViewModel1 = ViewModelProviders.of(this, viewModelFactory).get(DaggerPart5ViewModel1::class.java)// ViewModelProvider::getを使ってViewModelを取得する。
        daggerPart5ViewModel2 = ViewModelProviders.of(this, viewModelFactory).get(DaggerPart5ViewModel2::class.java)
        daggerPart5ViewModel3 = ViewModelProviders.of(this, viewModelFactory).get(DaggerPart5ViewModel3::class.java)

        Log.d(TAG, "Injection succeed!! Congratulations!!")
    }
}
