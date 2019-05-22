package com.github.mrz.dialog.builder;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.github.mrz.dialog.factory.BottomFactory;
import com.github.mrz.dialog.request.BottomRequest;

/**
 * @author Mrz
 * @date 2019/5/17 16:31
 */
public class BottomBuilder extends BaseBuilder<BottomBuilder, BottomFactory> implements BottomRequest {

    //bottom
    public BottomBuilder.BottomListener mBottomListener;

    private BottomBuilder(AppCompatActivity activity) {
        super(activity);
    }

    @Override
    public BottomFactory build() {

        return new BottomFactory(this);
    }

    public static BottomBuilder builder(AppCompatActivity activity) {
        return new BottomBuilder(activity);
    }


    public BottomBuilder setBottomListener(BottomListener bottomListener) {
        mBottomListener = bottomListener;
        return this;
    }


    public interface BottomListener {
        void onBottomListener(View view, int requesCode);
    }

}
