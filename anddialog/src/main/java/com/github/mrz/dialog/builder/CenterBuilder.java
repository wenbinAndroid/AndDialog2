package com.github.mrz.dialog.builder;

import android.support.v7.app.AppCompatActivity;

import com.github.mrz.dialog.factory.CenterFactory;
import com.github.mrz.dialog.request.CenterRequest;
import com.github.mrz.dialog.request.OnDialogListener;

/**
 * @author Mrz
 * @date 2019/5/17 16:43
 */
public class CenterBuilder extends BaseBuilder<CenterBuilder, CenterFactory> implements
        CenterRequest {


    //center
    public OnDialogListener mCenterListener;

    private CenterBuilder(AppCompatActivity activity) {
        super(activity);
    }

    @Override
    public CenterFactory build() {

        CenterFactory factory = new CenterFactory();
        factory.setBuilder(this);

        return factory;
    }

    public static CenterBuilder builder(AppCompatActivity activity) {
        return new CenterBuilder(activity);
    }

    @Override
    public CenterBuilder setDialogListener(OnDialogListener listener) {
        this.mCenterListener = listener;
        return this;
    }


}
