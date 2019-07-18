package com.example.testapp.epoxytest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.testapp.R
import com.example.testapp.databinding.ActivityEpoxyBinding

class EpoxyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityEpoxyBinding>(this, R.layout.activity_epoxy)

        val controller = EpoxyController()
        controller.setData(EpoxyData(
            "header1",
            listOf("aa", "ab", "ac"),
            "header2",
            listOf("ba", "bb", "bc", "bd", "bd")
        ))

        binding.recyclerView.adapter = controller.adapter
        binding.recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
    }
}
