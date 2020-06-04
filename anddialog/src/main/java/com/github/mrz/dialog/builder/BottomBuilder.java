package com.github.mrz.dialog.builder;

import android.support.v7.app.AppCompatActivity;

import com.github.mrz.dialog.factory.BottomFactory;
import com.github.mrz.dialog.request.BottomRequest;
import com.github.mrz.dialog.request.OnDialogListener;

/**
 * @author Mrz
 * @date 2019/5/17 16:31
 */
public class BottomBuilder extends BaseBuilder<BottomBuilder, BottomFactory> implements
        BottomRequest {

    //bottom
    public OnDialogListener mBottomListener;

    private BottomBuilder(AppCompatActivity activity) {
        super(activity);
        this.canceledOnTouchOutside = true;
    }

    @Override
    public BottomFactory build() {

        BottomFactory factory = new BottomFactory();
        factory.setBuilder(this);
        return factory;
    }

    public static BottomBuilder builder(AppCompatActivity activity) {
        return new BottomBuilder(activity);
    }

    @Override
    public BottomBuilder setDialogListener(OnDialogListener bottomListener) {
        mBottomListener = bottomListener;
        return this;
    }


}
