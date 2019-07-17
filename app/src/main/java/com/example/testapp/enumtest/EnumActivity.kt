package com.example.testapp.enumtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.testapp.R
import com.example.testapp.databinding.ActivityEnumBinding

class EnumActivity : AppCompatActivity(), View.OnClickListener {

    private var enumResult: EnumResult? = EnumResult()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityEnumBinding>(this, R.layout.activity_enum)
        binding.handler = this
        binding.enumResult = enumResult
    }

    /**
     * 引数numberに紐づいているTestEnumのNameTextを取得する。
     * @param number
     */
    private fun getEnumNameText(number: Int): String {
        return TestEnum.values().first { number == it.number }.nameText
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btn_a -> {
                enumResult?.enumName = getEnumNameText(2)
            }
            R.id.btn_b -> {
                enumResult?.enumName = getEnumNameText(4)
            }
            R.id.btn_c -> {
                enumResult?.enumName = getEnumNameText(6)
            }
        }
    }
}
