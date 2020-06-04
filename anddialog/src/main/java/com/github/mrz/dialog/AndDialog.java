package com.github.mrz.dialog;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.github.mrz.dialog.builder.BottomBuilder;
import com.github.mrz.dialog.builder.CenterBuilder;
import com.github.mrz.dialog.builder.CheckBuilder;
import com.github.mrz.dialog.builder.SingnleBulder;


/**
 * @author Mrz
 * @date 2018/10/29 13:54
 */

public class AndDialog implements LifecycleObserver {

    private AppCompatActivity mActivity;

    private AndDialog(AppCompatActivity activity) {
        this.mActivity = activity;
        registerLifeCycle();
    }


    private void registerLifeCycle() {
        if (mActivity != null && !mActivity.isFinishing()) {
            mActivity.getLifecycle().addObserver(this);
        }
    }

    public static AndDialog with(Fragment fragment) {
        return new AndDialog((AppCompatActivity) fragment.getActivity());
    }

    public static AndDialog with(AppCompatActivity activity) {
        return new AndDialog(activity);
    }


    public BottomBuilder bottom() {

        return BottomBuilder.builder(mActivity);
    }

    public CheckBuilder check() {
        return CheckBuilder.builder(mActivity);
    }


    public SingnleBulder single() {
        return SingnleBulder.builder(mActivity);
    }


    public CenterBuilder center() {
        return CenterBuilder.builder(mActivity);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private void onDestory() {
        mActivity = null;
    }

}
