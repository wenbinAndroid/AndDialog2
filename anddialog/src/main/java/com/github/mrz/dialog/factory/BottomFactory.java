package com.github.mrz.dialog.factory;

import android.annotation.SuppressLint;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.github.mrz.dialog.R;
import com.github.mrz.dialog.builder.BottomBuilder;

/**
 * @author Mrz
 * @date 2019/5/17 17:25
 */
@SuppressLint("ValidFragment")
public class BottomFactory extends BaseDialogFragment<BottomBuilder> {



    public BottomFactory(BottomBuilder builder) {
        super(builder);
    }

    @Override
    public int getStyle() {
        return mBuilder.style == 0 ? R.style.BottomDialog : mBuilder.style;
    }

    @Override
    protected void setDialogPosition() {
        Window window = getDialog().getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        params.gravity = Gravity.BOTTOM;
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        window.setAttributes(params);
    }

    @Override
    protected void init() {

        if (mBuilder.mBottomListener != null) {
            mBuilder.mBottomListener.onBottomListener(mView, mBuilder.requestCode);
        }
    }
}
