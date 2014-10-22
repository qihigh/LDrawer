package com.ikimuhendis.ldrawer.sample;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;

import butterknife.ButterKnife;

/**
 * Created by qihuan on 8/14/14.
 * 默认的activity
 */
public abstract class BaseActivity extends FragmentActivity {

    protected BaseActivity me = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        initContentView();
        ButterKnife.inject(this);
        init();
    }

    public abstract void initContentView();

    public abstract void initView();

    public abstract void initListener();

    public abstract void initData();

    /**
     * 默认初始化方法
     */
    public void init() {
        LogUtil.d("进入activity " + getClass().getName());
        initView();
        initData();
        initListener();
    }
}