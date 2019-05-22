package com.github.mrz.dialog.factory;

import android.annotation.SuppressLint;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.github.mrz.dialog.R;
import com.github.mrz.dialog.builder.CenterBuilder;

/**
 * @author Mrz
 * @date 2019/5/17 17:25
 */
@SuppressLint("ValidFragment")
public class CenterFactory extends BaseDialogFragment<CenterBuilder> {


    public CenterFactory(CenterBuilder builder) {
        super(builder);
    }

    @Override
    public int getStyle() {
        return mBuilder.style == 0 ? R.style.CenterDialog : mBuilder.style;
    }

    @Override
    protected void setDialogPosition() {
        Window window = getDialog().getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        params.gravity = Gravity.CENTER;
        int displayWidth = getDisplayWidth(mContext);
        params.width = (int) (displayWidth * mBuilder.widthAttr);
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(params);
    }

    @Override
    protected void init() {
        if (mBuilder.mCenterListener != null) {
            mBuilder.mCenterListener.onDialogListener(mView, this, mBuilder.requestCode);
        }
    }
}
