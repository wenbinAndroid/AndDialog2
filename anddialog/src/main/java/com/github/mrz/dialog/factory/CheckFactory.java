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
import com.github.mrz.dialog.builder.CheckBuilder;

/**
 * @author Mrz
 * @date 2019/5/17 17:25
 */

@SuppressLint("ValidFragment")
public class CheckFactory extends BaseDialogFragment<CheckBuilder> {


    public CheckFactory(CheckBuilder builder) {
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
        if (mBuilder.width > 0) {
            params.width = mBuilder.width;
        } else {
            params.width = (int) (displayWidth * mBuilder.widthAttr);
        }
        if (mBuilder.height > 0) {
            params.height = mBuilder.height;
        } else {
            params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        }
        window.setAttributes(params);
    }


    @Override
    protected void init() {
        showTitle();
        showContent();
        showLeftBtn();
        showRightBtn();
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
            System.out.println("titleId  be null");
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

            tvContent.getPaint().setFakeBoldText(mBuilder.boldContentText);

        } catch (Exception e) {
            System.out.println("contentId  is null");
        }
    }

    private void showLeftBtn() {
        try {
            TextView tvLeftBtn = mView.findViewById(mBuilder.leftIdRes);
            if (!TextUtils.isEmpty(mBuilder.leftText)) {
                tvLeftBtn.setText(mBuilder.leftText);
            }
            if (!TextUtils.isEmpty(mBuilder.leftTextColor)) {
                tvLeftBtn.setTextColor(Color.parseColor(mBuilder.leftTextColor));
            }
            if (mBuilder.leftTextColorRes != 0) {
                tvLeftBtn.setTextColor(ContextCompat.getColor(mContext, mBuilder
                        .leftTextColorRes));
            }
            if (mBuilder.leftTextSize != 0) {
                tvLeftBtn.setTextSize(dp2Px(mBuilder.leftTextSize));
            }
            if (mBuilder.leftBtnBackground != 0) {
                tvLeftBtn.setBackgroundResource(mBuilder.leftBtnBackground);
            }

            tvLeftBtn.getPaint().setFakeBoldText(mBuilder.boldLeftText);

            tvLeftBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mBuilder.mLeftBtnListener != null) {
                        mBuilder.mLeftBtnListener.onLeftBtnClick(mBuilder.requestCode);
                    }
                    if (!mBuilder.keepState) {
                        dismiss();
                    }
                }
            });
        } catch (Exception e) {
            System.out.println("leftId is null");
        }
    }

    private void showRightBtn() {
        try {
            TextView tvRightBtn = mView.findViewById(mBuilder.rightIdRes);
            if (!TextUtils.isEmpty(mBuilder.rightText)) {
                tvRightBtn.setText(mBuilder.rightText);
            }
            if (!TextUtils.isEmpty(mBuilder.rightTextColor)) {
                tvRightBtn.setTextColor(Color.parseColor(mBuilder.rightTextColor));
            }
            if (mBuilder.rightTexColorRes != 0) {
                tvRightBtn.setTextColor(ContextCompat.getColor(mContext, mBuilder
                        .rightTexColorRes));
            }
            if (mBuilder.rightTextSize != 0) {
                tvRightBtn.setTextSize(dp2Px(mBuilder.rightTextSize));
            }
            if (mBuilder.rightBtnBackground != 0) {
                tvRightBtn.setBackgroundResource(mBuilder.rightBtnBackground);
            }
            tvRightBtn.getPaint().setFakeBoldText(mBuilder.boldRightText);
            tvRightBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mBuilder.mRightBtnListener != null) {
                        mBuilder.mRightBtnListener.onRightBtnClick(mBuilder.requestCode);
                    }
                    if (!mBuilder.keepState) {
                        dismiss();
                    }
                }
            });
        } catch (Exception e) {
            System.out.println("rightId is null");
        }
    }

}
