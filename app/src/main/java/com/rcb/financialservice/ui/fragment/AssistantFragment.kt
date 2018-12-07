package com.rcb.financialservice.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rcb.financialservice.R
import com.rcb.financialservice.ui.base.BaseFragment

class AssistantFragment : BaseFragment() {
    override fun getContentview() = R.layout.assistant_fragment

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = super.onCreateView(inflater, container, savedInstanceState)

        return view
    }

}
