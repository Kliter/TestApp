package com.example.testapp.databindingtest.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.testapp.R
import com.example.testapp.databinding.ActivityDataBindingBinding
import com.example.testapp.databindingtest.contract.OnChangeClickListener
import com.example.testapp.databindingtest.model.User
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_data_binding.*
import org.koin.android.ext.android.inject

class DataBindingActivity : AppCompatActivity(), OnChangeClickListener {

    companion object {
        private const val TAG = "DataBindingActivity"
    }

   private val mUser: User by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // If you use DataBinding library,
        //  you have to use DataBindingUtil.setContentView<T extends ViewDataBinding>(activity: Activity, layoutId: Int)
        //  instead of setContentView().
        val binding = DataBindingUtil.setContentView<ActivityDataBindingBinding>(this, R.layout.activity_data_binding)
        binding.user = mUser
        binding.handler = this
    }

    override fun onChangeClick(view: View) {
        Snackbar.make(linear_layout_databinding_container, "ChangeButton is pressed.", Snackbar.LENGTH_SHORT).show()
        mUser.name = "LK"
    }
}
