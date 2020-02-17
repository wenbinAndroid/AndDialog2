package com.github.mrz.dialog.factory;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.github.mrz.dialog.R;
import com.github.mrz.dialog.builder.SingnleBulder;
import com.github.mrz.dialog.config.FactoryConfig;

/**
 * @author Mrz
 * @date 2019/5/17 17:25
 */
@SuppressLint("ValidFragment")
public class SingleFactory extends BaseDialogFragment<SingnleBulder> {


    public SingleFactory(SingnleBulder builder) {
        super(builder);
    }

    @Override
    public int getStyle() {
        if (mBuilder.style != -1) {
            return mBuilder.style;
        } else if (FactoryConfig.getDefaultCenterAniamtionStyle() != -1) {
            return FactoryConfig.getDefaultCenterAniamtionStyle();
        }
        return R.style.CenterDialog;
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
        showTitle();
        showContent();
        showSingleText();
    }


    private void showTitle() {
        try {
            TextView tvTitle = mView.findViewById(mBuilder.titleIdRes);
            if (!TextUtils.isEmpty(mBuilder.titleText)) {
                tvTitle.setText(mBuilder.titleText);
            }
            if (!TextUtils.isEmpty(mBuilder.titleColor)) {
                tvTitle.setTextColor(Color.parseColor(mBuilder.titleColor));
            }
            if (mBuilder.titleColorRes != 0) {
                tvTitle.setTextColor(ContextCompat.getColor(mContext, mBuilder.titleColorRes));
            }
            if (mBuilder.titleTextSize != 0) {
                tvTitle.setTextSize(dp2Px(mBuilder.titleTextSize));
            }
            tvTitle.getPaint().setFakeBoldText(mBuilder.titleBoldText);

        } catch (Exception e) {
            System.out.println("titleId  is null");
        }

    }

    private void showContent() {
        try {
            TextView tvContent = mView.findViewById(mBuilder.contentTextIdRes);
            if (!TextUtils.isEmpty(mBuilder.contentText)) {
                tvContent.setText(mBuilder.contentText);
            }
            if (!TextUtils.isEmpty(mBuilder.contentTextColor)) {
                tvContent.setTextColor(Color.parseColor(mBuilder.contentTextColor));
            }
            if (mBuilder.contentTextColorRes != 0) {
                tvContent.setTextColor(ContextCompat.getColor(mContext, mBuilder
                        .contentTextColorRes));
            }
            if (mBuilder.contentTextSize != 0) {
                tvContent.setTextSize(dp2Px(mBuilder.contentTextSize));
            }
            tvContent.getPaint().setFakeBoldText(mBuilder.contentBoldText);
        } catch (Exception e) {
            System.out.println("contentId  is null");
        }
    }

    private void showSingleText() {
        try {
            TextView tvSingle = mView.findViewById(mBuilder.singleBtnIdRes);
            if (!TextUtils.isEmpty(mBuilder.singleText)) {
                tvSingle.setText(mBuilder.singleText);
            }
            if (!TextUtils.isEmpty(mBuilder.singleTextColor)) {
                tvSingle.setTextColor(Color.parseColor(mBuilder.singleTextColor));
            }
            if (mBuilder.singleTextColorRes != 0) {
                tvSingle.setTextColor(ContextCompat.getColor(mContext, mBuilder
                        .singleTextColorRes));
            }
            if (mBuilder.singleTextSize != 0) {
                tvSingle.setTextSize(dp2Px(mBuilder.singleTextSize));
            }
            if (mBuilder.singleBackground != 0) {
                tvSingle.setBackgroundResource(mBuilder.singleBackground);
            }

            tvSingle.getPaint().setFakeBoldText(mBuilder.singleBoldText);
            tvSingle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mBuilder.mSingleListener != null) {
                        mBuilder.mSingleListener.onSingleBtnClick(mBuilder.requestCode);
                    }
                    if (!mBuilder.keepState) {
                        dismiss();
                    }
                }
            });
        } catch (Exception e) {
            System.out.println("singleId  is null");
        }
    }
}
