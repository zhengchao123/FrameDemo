package com.rcb.financialservice.ui.activity

import android.graphics.Rect
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.rcb.financialservice.R
import com.rcb.financialservice.databinding.ActivityMainBinding
import com.rcb.financialservice.net.netretrofit.ApiClient
import com.rcb.financialservice.net.netretrofit.body.FindFaceBody
import com.rcb.financialservice.net.netretrofit.entity.BaseEntity
import com.rcb.financialservice.net.netretrofit.entity.FindFaceEntity
import com.rcb.financialservice.ui.base.BaseActivity
import com.rcb.financialservice.ui.fragment.AssistantFragment
import com.rcb.financialservice.ui.fragment.LifeFragment
import com.rcb.financialservice.ui.fragment.MainFragment
import com.rcb.financialservice.ui.fragment.MineFragment
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.lang.Exception
import java.util.concurrent.TimeUnit

class MainActivity : BaseActivity() {

    override fun getContentViewId() = R.layout.activity_main


    private var mCurrentFragment: Fragment? = null;
    private lateinit var mMainFrameLayout: FrameLayout;
    private lateinit var mFragmentManager: FragmentManager;

    private val TAG_MAIN_FRAGMENT = "MAIN_FRAGMENT";
    private val TAG_LIFE_FRAGMENT = "LIFE_FRAGMENT";
    private val TAG_ASSISTANT_FRAGMENT = "ASSISTANT_FRAGMENT";
    private val TAG_MINE_FRAGMENT = "MINE_FRAGMENT";


    private lateinit var mMainActivityBinding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showFragment(TAG_MAIN_FRAGMENT);
    }
    override fun initBinding() {
        mMainActivityBinding = binding as ActivityMainBinding;

    }

    override fun initView() {
        super.initView()
        closeTitleBar(true)
        mMainFrameLayout = mMainActivityBinding.mainFragment;
    }

    override fun initData() {
        super.initData()
        mFragmentManager = supportFragmentManager;
    }
    override fun initListener() {
        super.initListener()
        mMainActivityBinding.radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.rb_1 -> {
                    Toast.makeText(mContext, " rb_1 checked", Toast.LENGTH_LONG).show()
                    showFragment(TAG_MAIN_FRAGMENT);
                }
                R.id.rb_2 -> {
                    Toast.makeText(mContext, " rb_2 checked", Toast.LENGTH_LONG).show()
                    showFragment(TAG_ASSISTANT_FRAGMENT);
                }
                R.id.rb_3 -> {
                    Toast.makeText(mContext, " rb_3 checked", Toast.LENGTH_LONG).show()
                    showFragment(TAG_LIFE_FRAGMENT);
                }
                R.id.rb_4 -> {
                    Toast.makeText(mContext, " rb_4 checked", Toast.LENGTH_LONG).show()
                    showFragment(TAG_MINE_FRAGMENT);
                }
            }
        }
    }


    fun showFragment(tag: String?): Unit {
        if (mCurrentFragment != null) {
            getSupportFragmentManager().beginTransaction().hide(mCurrentFragment!!).commit();
        }
        mCurrentFragment = mFragmentManager.findFragmentByTag(tag);
        if (mCurrentFragment == null) {
            when (tag) {
                TAG_MAIN_FRAGMENT ->
                    mCurrentFragment = MainFragment();
                TAG_ASSISTANT_FRAGMENT ->
                    mCurrentFragment = LifeFragment();
                TAG_LIFE_FRAGMENT ->
                    mCurrentFragment = AssistantFragment();
                TAG_MINE_FRAGMENT ->
                    mCurrentFragment = MineFragment();

            }
            mFragmentManager.beginTransaction().add(mMainFrameLayout.id, this.mCurrentFragment!!, tag).commit();
        } else {
            mFragmentManager.beginTransaction().show(mCurrentFragment!!).commit();
        }
    }



    fun retrofitTest(){
        ApiClient.getApiService().findFace( FindFaceBody(""))
            .subscribe(object : Observer<BaseEntity<FindFaceEntity>> {
                override fun onNext(entity: BaseEntity<FindFaceEntity>) {
                    if (entity.isSuccess) {
                        val faceEntity = entity.getResult()

                    } else {
                    }

                }

                override fun onSubscribe(d: Disposable) {
//                    mFindFaceDisposable = d
                }


                override fun onError(e: Throwable) {
                }

                override fun onComplete() {}
            })
    }

    fun startTimer(){
        Observable.interval(0, 1, TimeUnit.SECONDS)
            .subscribeOn(Schedulers.single())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<Long> {
                override fun onComplete() {
                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onNext(t: Long) {


                }

                override fun onError(e: Throwable) {
                }

            })
    }

    fun syncDemo(){
        Observable.create(ObservableOnSubscribe<String> {
            it.onNext("")
        }).subscribeOn(Schedulers.io()).subscribe { _ ->
        }
    }
}
