package com.github.mrz.dialog.builder;

import android.support.v7.app.AppCompatActivity;

import com.github.mrz.dialog.config.FactoryConfig;
import com.github.mrz.dialog.request.BaseRquest;

/**
 * @author Mrz
 * @date 2019/5/17 15:24
 */
public abstract class BaseBuilder<T, V> implements BaseRquest<T> {
    public boolean cancelable = FactoryConfig.isDefaultCancelable();
    public boolean canceledOnTouchOutside = FactoryConfig.isDefaultCanceledOnTouchOutside();
    public float widthAttr = FactoryConfig.getDefaultWidthAttr();
    public float backgroundDimAmount = FactoryConfig.getDefaultbackgroundDimAmount();
    public int width;
    public int height;
    public int requestCode;
    public int layout;
    public AppCompatActivity mActivity;
    public boolean keepState;
    public int style;

    public BaseBuilder(AppCompatActivity activity) {
        mActivity = activity;
    }

    @Override
    public T setLayout(int layout) {
        this.layout = layout;
        return (T) this;
    }


    @Override
    public T setStyle(int style) {
        this.style = style;
        return (T) this;
    }

    @Override
    public T setCancelable(boolean cancelable) {
        this.cancelable = cancelable;
        return (T) this;
    }

    @Override
    public T setWidth(int width) {
        this.width = width;
        return (T) this;
    }

    @Override
    public T setWidthAttr(float widthAttr) {
        this.widthAttr = widthAttr;
        return (T) this;
    }

    @Override
    public T setHeight(int height) {
        this.height = height;
        return (T) this;
    }

    @Override
    public T setRequestCode(int requestCode) {
        this.requestCode = requestCode;
        return (T) this;
    }

    @Override
    public T setCanceledOnTouchOutside(boolean canceledOnTouchOutside) {
        this.canceledOnTouchOutside = canceledOnTouchOutside;
        return (T) this;
    }

    @Override
    public T setBackgroundDimAmount(float count) {
        this.backgroundDimAmount = count;
        return (T) this;
    }


    public abstract V build();
}
