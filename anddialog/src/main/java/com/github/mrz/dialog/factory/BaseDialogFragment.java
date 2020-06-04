package com.github.mrz.dialog.factory;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.github.mrz.dialog.builder.BaseBuilder;

/**
 * @author Mrz
 * @date 2019/5/17 15:19
 */

public abstract class BaseDialogFragment<V extends BaseBuilder> extends DialogFragment {

    protected V mBuilder;
    protected Context mContext;
    protected View mView;
    private static final String TAG = "BaseDialogFragment";
    protected boolean isInit;


    public void setBuilder(V builder) {
        this.mBuilder = builder;
        Log.d(TAG, "setBuilder: ");
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mContext = context.getApplicationContext();
        } catch (Exception e) {
            mContext = context;
        }

    }


    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(null);
        if (mBuilder != null) {
            if (getStyle() > 0) {
                setStyle(0, getStyle());
                Log.d(TAG, "onCreate: ");
            }
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        if (!isInit) {
            setDialogPosition();
            init();
            setBackgroundDimEnabled();
            isInit = true;
        }
    }

    public void refresh() {
        init();
    }


    protected void setDialogPosition() {

    }

    protected void init() {

    }


    protected int getDisplayWidth(Context context) {
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        return width;
    }


    public abstract int getStyle();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        setCancelable(mBuilder.cancelable);
        getDialog().setCanceledOnTouchOutside(mBuilder.canceledOnTouchOutside);
        Dialog dialog = getDialog();
        if (dialog != null) {
            //在5.0以下的版本会出现白色背景边框，若在5.0以下设置则会造成文字部分的背景也变成透明
            if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT) {
                //目前只有这两个dialog会出现边框
                if (dialog instanceof ProgressDialog || dialog instanceof DatePickerDialog) {
                    getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color
                            .TRANSPARENT));
                }
            }
        }
        int resLayout = mBuilder.layout;
        if (resLayout == 0) {
            throw new IllegalStateException("layout must be not null");
        }
        mView = inflater.inflate(resLayout, null);
        return mView;
    }

    private void setBackgroundDimEnabled() {
        Window mWindow = getDialog().getWindow();
        WindowManager.LayoutParams lp = mWindow.getAttributes();
        lp.dimAmount = mBuilder.backgroundDimAmount;
        mWindow.setAttributes(lp);
    }


    protected int dp2Px(int dpValue) {
        final float scale = mContext.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
    }


    @Override
    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
    }

    private void show(FragmentManager transaction) {
        try {
            show(transaction, "");
        } catch (Exception e) {

        }
    }

    public BaseDialogFragment show() {
        if (mBuilder != null && mBuilder.mActivity != null) {
            show(mBuilder.mActivity.getSupportFragmentManager());
        }
        return this;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
        reset();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
    }


    private void reset() {
        mContext = null;
        mView = null;
        mBuilder = null;
    }

}
