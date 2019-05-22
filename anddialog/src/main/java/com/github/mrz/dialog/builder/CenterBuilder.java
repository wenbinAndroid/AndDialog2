package com.github.mrz.dialog.builder;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

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

        return new CenterFactory(this);
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
