package com.github.mrz.dialog.builder;

import android.support.v7.app.AppCompatActivity;

import com.github.mrz.dialog.factory.CheckFactory;

/**
 * @author Mrz
 * @date 2019/5/17 15:54
 */
public class CheckBuilder extends BaseBuilder<CheckBuilder, CheckFactory> implements CheckRequest {


    //title
    public String titleText;
    public String titleColor;
    public int titleTextSize;
    public int titleColorRes;
    public int titleIdRes;
    public boolean titleBoldText;
    //content
    public String contentText;
    public String contentTextColor;
    public int contentTextSize;
    public int contentTextColorRes;
    public int contentTextIdRes;
    public boolean boldContentText;

    //left
    public String leftText;
    public int leftTextSize;
    public int leftTextColorRes;
    public boolean boldLeftText;
    public String leftTextColor;
    public int leftIdRes;
    public int leftBtnBackground;
    public CheckBuilder.LeftBtnListener mLeftBtnListener;
    //right
    public String rightText;
    public int rightTextSize;
    public int rightTexColorRes;
    public boolean boldRightText;
    public String rightTextColor;
    public int rightIdRes;
    public int rightBtnBackground;
    public CheckBuilder.RightBtnListener mRightBtnListener;

    private CheckBuilder(AppCompatActivity activity) {
        super(activity);
    }

    @Override
    public CheckFactory build() {

        return new CheckFactory(this);
    }


    public static CheckBuilder builder(AppCompatActivity activity) {
        return new CheckBuilder(activity);
    }


    @Override
    public CheckBuilder setLeftText(int leftIdRes, String text) {
        this.leftIdRes = leftIdRes;
        this.leftText = text;
        return this;
    }

    @Override
    public CheckBuilder setLeftText(int leftIdRes, String text, LeftBtnListener listener) {
        this.leftIdRes = leftIdRes;
        this.leftText = text;
        this.mLeftBtnListener = listener;
        return this;
    }

    @Override
    public CheckBuilder setLeftText(String text) {
        this.leftText = text;
        return this;
    }

    @Override
    public CheckBuilder setLeftTextId(int leftIdRes) {
        this.leftIdRes = leftIdRes;
        return this;
    }


    @Override
    public CheckBuilder setLeftTextSize(int size) {
        this.leftTextSize = size;
        return this;
    }

    @Override
    public CheckBuilder setLeftTextColor(int color) {
        this.leftTextColorRes = color;
        return this;
    }

    @Override
    public CheckBuilder setBoldLeftText(boolean state) {
        this.boldLeftText = state;
        return this;
    }


    @Override
    public CheckBuilder setLeftTextColor(String color) {
        this.leftTextColor = color;
        return this;
    }

    @Override
    public CheckBuilder setLeftBackground(int background) {
        this.leftBtnBackground = background;
        return this;
    }

    @Override
    public CheckBuilder setLeftBtnListener(LeftBtnListener listener) {
        this.mLeftBtnListener = listener;
        return this;
    }

    @Override
    public CheckBuilder setRightText(String text) {
        this.rightText = text;
        return this;
    }

    @Override
    public CheckBuilder setRightText(int id, String text) {
        this.rightText = text;
        this.rightIdRes = id;
        return this;
    }

    @Override
    public CheckBuilder setRightText(int id, String text, RightBtnListener listener) {
        this.rightText = text;
        this.rightIdRes = id;
        this.mRightBtnListener = listener;
        return this;
    }

    @Override
    public CheckBuilder setRightTextId(int rightIdRes) {
        this.rightIdRes = rightIdRes;
        return this;
    }

    @Override
    public CheckBuilder setRightTextSize(int size) {
        this.rightTextSize = size;
        return this;
    }

    @Override
    public CheckBuilder setRightTexColor(int coloRes) {
        this.rightTexColorRes = coloRes;
        return this;
    }

    @Override
    public CheckBuilder setBoldRightText(boolean state) {
        this.boldRightText = state;
        return this;
    }


    @Override
    public CheckBuilder setRightTexColor(String color) {
        this.rightTextColor = color;
        return this;
    }

    @Override
    public CheckBuilder setRightBtnListener(RightBtnListener listener) {
        this.mRightBtnListener = listener;
        return this;
    }


    @Override
    public CheckBuilder setRightBackground(int background) {
        this.rightBtnBackground = background;
        return this;
    }


    @Override
    public CheckBuilder setTitleText(int id, String title) {
        this.titleIdRes = id;
        this.titleText = title;
        return this;
    }

    @Override
    public CheckBuilder setTitleText(String title) {
        this.titleText = title;
        return this;
    }

    @Override
    public CheckBuilder setTitleColor(String color) {
        this.titleColor = color;
        return this;
    }

    @Override
    public CheckBuilder setTitleColor(int colorRes) {
        this.titleColorRes = colorRes;
        return this;
    }

    @Override
    public CheckBuilder setTitleTextSize(int size) {
        this.titleTextSize = size;
        return this;
    }

    @Override
    public CheckBuilder setTitleTextId(int id) {
        this.titleIdRes = id;
        return this;
    }


    @Override
    public CheckBuilder setBoldTitleText(boolean state) {
        this.titleBoldText = state;
        return this;
    }


    @Override
    public CheckBuilder setContentText(int id, String content) {
        this.contentTextIdRes = id;
        this.contentText = content;
        return this;
    }

    @Override
    public CheckBuilder setContentTextColor(String color) {
        this.contentTextColor = color;
        return this;
    }

    @Override
    public CheckBuilder setContentTextColor(int color) {
        this.contentTextColorRes = color;
        return this;
    }

    @Override
    public CheckBuilder setBoldContentText(boolean state) {
        this.boldContentText = state;
        return this;
    }


    @Override
    public CheckBuilder setContentTextSize(int size) {
        this.contentTextSize = size;
        return this;
    }

    @Override
    public CheckBuilder setContentTextId(int id) {
        this.contentTextIdRes = id;
        return this;
    }

    @Override
    public CheckBuilder setKeepState(boolean state) {
        this.keepState = state;
        return this;
    }

    public interface LeftBtnListener {
        void onLeftBtnClick(int requestCode);
    }


    public interface RightBtnListener {
        void onRightBtnClick(int requestCode);
    }
}
