package com.example.testapp.daggertest.part3.di

import com.example.testapp.daggertest.common.MyApplication
import com.example.testapp.daggertest.part3.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * AndroidInjectionModule::class
 * 2.10から追加された。
 */
/**
 * @BindsInstance
 * 2.9から追加された。
 * 自分でコンポーネントを構築する時に、これを指定したメソッド(ここではapplication)を呼び出すことで、
 * 引数をコンポーネントにInjectできるようになる。
 * これがないと、ボイラープレートを記述しないといけない。
 */
@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        DaggerPart3Module::class
    ]
)
interface DaggerPart3Component {

    fun inject(application: Application)

    /**
     * Builder→Factoryの変化は、
     * あくまでComponentの取得方法が
     * builder().XXX(XXX).build()から、
     * factory().create(XXX)に変わっただけ。
     */
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): DaggerPart3Component
    }

    /**
     * @BindsInstance fun application(application: MyApplication): Builder
     * と書かない場合は、以下のようにContextをInjectしようとしてもコンパイルエラーになる。
     */
    /**
     * @Module
     * class AppModule {
     *      @Provides
     *      fun provideContext(application: MyApplication) = application.applicationContext
     * }
     * class MainDao @Inject constructor() {
     *      @Inject
     *      lateinit var context: Context
     * }
     */

}
