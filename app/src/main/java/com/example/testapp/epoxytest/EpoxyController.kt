package com.example.testapp.epoxytest

import com.airbnb.epoxy.TypedEpoxyController
import com.example.testapp.LayoutEpoxyContent1BindingModel_
import com.example.testapp.LayoutEpoxyContent2BindingModel_
import com.example.testapp.LayoutEpoxyHeader1BindingModel_
import com.example.testapp.LayoutEpoxyHeader2BindingModel_

class EpoxyController: TypedEpoxyController<EpoxyData>() {

    override fun buildModels(data: EpoxyData) {
        LayoutEpoxyHeader1BindingModel_()
            .title(data.header1)
            .id(modelCountBuiltSoFar)
            .addTo(this)

        for (item in data.contents1) {
            LayoutEpoxyContent1BindingModel_()
                .text(item)
                .id(modelCountBuiltSoFar)
                .addTo(this)
        }

        LayoutEpoxyHeader2BindingModel_()
            .title(data.header2)
            .id(modelCountBuiltSoFar)
            .addTo(this)

        for (item in data.contents2) {
            LayoutEpoxyContent2BindingModel_()
                .text(item).id(modelCountBuiltSoFar)
                .addTo(this)
        }
    }
}