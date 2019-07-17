package com.example.testapp.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.testapp.R
import kotlinx.android.synthetic.main.activity_live_data.*

class LiveDataActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var model: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data)
        btn_name_change.setOnClickListener(this)

        /**
         * 1.ViewModelが保持しているフィールドがMutableLiveDataでラッピングされて、監視可能になる。
         * 2.監視役(Observer)であるActivityやFragmentでViewModelをインスタンス化して保持する。
         *   ※MVVMに沿って実装していれば、自然とViewModelを保持することになるはず。
         * 3.監視役までのパイプ(ここではnameObserver)を生成する。
         * 4.パイプに値が変更された時の処理(UIを更新する処理)を記述する。
         * 5.ViewModelのインスタンスが持つ監視対象のフィールドへ、ownerである自身とパイプを渡して完了。
         */

        // Get the ViewModel.
        model = ViewModelProviders.of(this).get(MyViewModel::class.java)

        // Create the observer which updates the UI.
        val nameObserver = Observer<String> { newName ->
            // Update the UI, in this case, a TextView.
            tv_name.text = newName
        }

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        model.currentName.observe(this, nameObserver)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btn_name_change -> {
                val anotherName = "John Doe"
                model.currentName.setValue(anotherName) // ViewModelが保持する監視対象のフィールドが更新されると、UIも更新される。
            }
        }
    }
}
