package com.github.mrz.dialog.factory;

import android.annotation.SuppressLint;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.github.mrz.dialog.R;
import com.github.mrz.dialog.builder.BottomBuilder;
import com.github.mrz.dialog.config.FactoryConfig;

/**
 * @author Mrz
 * @date 2019/5/17 17:25
 */
public class BottomFactory extends BaseDialogFragment<BottomBuilder> {



    @Override
    public int getStyle() {
        if (mBuilder.style != -1) {
            return mBuilder.style;
        } else if (FactoryConfig.getDefaultBottomAniamtionStyle() != -1) {
            return FactoryConfig.getDefaultBottomAniamtionStyle();
        }
        return R.style.BottomDialog;
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
            mBuilder.mBottomListener.onDialogListener(mView, this, mBuilder.requestCode);
        }
    }
}
