package com.github.mrz.dialog.request;

import android.support.annotation.IdRes;

import com.github.mrz.dialog.builder.CheckBuilder;

/**
 * @author Mrz
 * @date 2019/5/17 16:08
 */
public interface CheckRequest extends BaseRquest<CheckBuilder> {

    //left
    CheckBuilder setLeftText(int leftIdRes, String text);
    CheckBuilder setLeftText(int leftIdRes, String text,CheckBuilder.LeftBtnListener listener);

    CheckBuilder setLeftText(String text);

    CheckBuilder setLeftTextId(int leftIdRes);

    CheckBuilder setLeftTextSize(int size);

    CheckBuilder setLeftTextColor(@IdRes int color);

    CheckBuilder setBoldLeftText(boolean state);



    CheckBuilder setLeftTextColor(String color);

    CheckBuilder setLeftBackground(int background);



    CheckBuilder setLeftBtnListener(CheckBuilder.LeftBtnListener listener);


    //right
    CheckBuilder setRightText(String text);

    CheckBuilder setRightText(int id, String text);
    CheckBuilder setRightText(int id, String text,CheckBuilder.RightBtnListener listener);

    CheckBuilder setRightTextId(int rightIdRes);

    CheckBuilder setRightTextSize(int size);

    CheckBuilder setRightTexColor(@IdRes int coloRes);

    CheckBuilder setBoldRightText(boolean state);


    CheckBuilder setRightTexColor(String color);

    CheckBuilder setRightBtnListener(CheckBuilder.RightBtnListener listener);

    CheckBuilder setRightBackground(int background);


    //title

    CheckBuilder setTitleText(int id, String title);

    CheckBuilder setTitleText(String title);

    CheckBuilder setTitleColor(String color);

    CheckBuilder setTitleColor(@IdRes int colorRes);

    CheckBuilder setTitleTextSize(int size);

    CheckBuilder setTitleTextId(int id);

    CheckBuilder setBoldTitleText(boolean state);


    //content

    CheckBuilder setContentText(int id, String content);

    CheckBuilder setContentTextColor(String color);

    CheckBuilder setContentTextColor(@IdRes int color);

    CheckBuilder setBoldContentText(boolean style);


    CheckBuilder setContentTextSize(int size);

    CheckBuilder setContentTextId(int id);

    CheckBuilder setKeepState(boolean state);


}
