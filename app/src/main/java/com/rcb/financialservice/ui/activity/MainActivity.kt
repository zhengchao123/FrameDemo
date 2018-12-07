package com.rcb.financialservice.ui.activity

import android.os.Bundle
import android.view.View
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.rcb.financialservice.R
import com.rcb.financialservice.databinding.ActivityMainBinding
import com.rcb.financialservice.ui.base.BaseActivity
import com.rcb.financialservice.ui.event.EventHandler
import decoration.scsowing.com.decoration.utils.LogUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun getContentViewId() = R.layout.activity_main


    private lateinit var mMainActivityBinding: ActivityMainBinding

    override fun initBinding() {
        mMainActivityBinding = binding as ActivityMainBinding;

    }

    override fun initView() {
        super.initView()
        closeTitleBar(true)

//        changeStatus(mMainActivityBinding.llMain, true)
//        changeStatus(mMainActivityBinding.llWorker, false)
//        changeStatus(mMainActivityBinding.llDesign, false)
//        changeStatus(mMainActivityBinding.llMine, false)

//        mMainActivityBinding.click = object : EventHandler(this.applicationContext) {
//            override fun onClickView(view: View) {
//                this.defaultAction(false)
//                super.onClickView(view)
//
//                when (view.id) {
//                    R.id.ll_main -> {
//                        changeStatus(mMainActivityBinding.llMain, true)
//                        changeStatus(mMainActivityBinding.llWorker, false)
//                        changeStatus(mMainActivityBinding.llDesign, false)
//                        changeStatus(mMainActivityBinding.llMine, false)
////                        showFragment(TAG_MAIN_FRAGMENT);
//                        LogUtils.i(TAG, " tv_main onclick ");
//                    }
//                    R.id.ll_worker -> {
//                        changeStatus(mMainActivityBinding.llMain, false)
//                        changeStatus(mMainActivityBinding.llWorker, true)
//                        changeStatus(mMainActivityBinding.llDesign, false)
//                        changeStatus(mMainActivityBinding.llMine, false)
////                        showFragment(TAG_WORKER_FRAGMENT);
//                        LogUtils.i(TAG, " tv_worker onclick ");
//                    }
//                    R.id.ll_design -> {
//                        changeStatus(mMainActivityBinding.llMain, false)
//                        changeStatus(mMainActivityBinding.llWorker, false)
//                        changeStatus(mMainActivityBinding.llDesign, true)
//                        changeStatus(mMainActivityBinding.llMine, false)
////                        showFragment(TAG_DESIGN_FRAGMENT);
//                        LogUtils.i(TAG, " tv_design onclick ");
//                    }
//                    R.id.ll_mine -> {
//                        changeStatus(mMainActivityBinding.llMain, false)
//                        changeStatus(mMainActivityBinding.llWorker, false)
//                        changeStatus(mMainActivityBinding.llDesign, false)
//                        changeStatus(mMainActivityBinding.llMine, true)
////                        showFragment(TAG_MINE_FRAGMENT);
//                        LogUtils.i(TAG, " tv_mine onclick ");
//                    }
//                }
//            }
//        }
    }

    override fun initListener() {
        super.initListener()
        mMainActivityBinding.radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.rb_1 -> Toast.makeText(mContext, " rb_1 checked", Toast.LENGTH_LONG).show()
                R.id.rb_2 -> Toast.makeText(mContext, " rb_2 checked", Toast.LENGTH_LONG).show()
                R.id.rb_3 -> Toast.makeText(mContext, " rb_3 checked", Toast.LENGTH_LONG).show()
                R.id.rb_4 -> Toast.makeText(mContext, " rb_4 checked", Toast.LENGTH_LONG).show()
            }
        }
    }

}
