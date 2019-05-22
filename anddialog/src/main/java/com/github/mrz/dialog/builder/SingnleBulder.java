package com.github.mrz.dialog.builder;

import android.support.v7.app.AppCompatActivity;

import com.github.mrz.dialog.factory.SingleFactory;
import com.github.mrz.dialog.request.SingleRequest;

/**
 * @author Mrz
 * @date 2019/5/17 16:34
 */
public class SingnleBulder extends BaseBuilder<SingnleBulder, SingleFactory> implements
        SingleRequest {

    //single
    public String singleText;
    public String singleTextColor;
    public int singleTextColorRes;
    public int singleTextSize;
    public int singleBtnIdRes;
    public int singleBackground;
    public boolean keepState;
    public boolean singleBoldText;
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
    public SingnleBulder.SingleListener mSingleListener;
    public boolean contentBoldText;

    private SingnleBulder(AppCompatActivity activity) {
        super(activity);
    }

    public static SingnleBulder builder(AppCompatActivity activity) {
        return new SingnleBulder(activity);
    }

    @Override
    public SingleFactory build() {
        return new SingleFactory(this);
    }

    @Override
    public SingnleBulder setTitleText(int id, String title) {
        this.titleIdRes = id;
        this.titleText = title;
        return this;
    }

    @Override
    public SingnleBulder setTitleText(String title) {
        this.titleText = title;
        return this;
    }

    @Override
    public SingnleBulder setTitleColor(String color) {
        this.titleColor = color;
        return this;
    }

    @Override
    public SingnleBulder setTitleColor(int colorRes) {
        this.titleColorRes = colorRes;
        return this;
    }

    @Override
    public SingnleBulder setTitleTextSize(int size) {
        this.titleTextSize = size;
        return this;
    }

    @Override
    public SingnleBulder setTitleTextId(int id) {
        this.titleIdRes = id;
        return this;
    }


    @Override
    public SingnleBulder setBoldTitleText(boolean state) {
        this.titleBoldText = state;
        return this;
    }


    @Override
    public SingnleBulder setContentText(String content) {
        this.contentText = content;
        return this;
    }

    @Override
    public SingnleBulder setContentText(int id, String content) {
        this.contentTextIdRes = id;
        this.contentText = content;
        return this;
    }

    @Override
    public SingnleBulder setContentTextColor(String color) {
        this.contentTextColor = color;
        return this;
    }

    @Override
    public SingnleBulder setContentTextColor(int color) {
        this.contentTextColorRes = color;
        return this;
    }

    @Override
    public SingnleBulder setContentTextSize(int size) {
        this.contentTextSize = size;
        return this;
    }

    @Override
    public SingnleBulder setContentId(int id) {
        this.contentTextIdRes = id;
        return this;
    }


    @Override
    public SingnleBulder setBoldContentText(boolean state) {
        this.contentBoldText = state;
        return this;
    }


    @Override
    public SingnleBulder setSingleTextSize(int size) {
        this.singleTextSize = size;
        return this;
    }

    @Override
    public SingnleBulder setSingleTextColor(int colorRes) {
        this.singleTextColorRes = colorRes;
        return this;
    }

    @Override
    public SingnleBulder setSingleTextColor(String color) {
        this.singleTextColor = color;
        return this;
    }

    @Override
    public SingnleBulder setSingleText(int id, String text) {
        this.singleBtnIdRes = id;
        this.singleText = text;
        return this;
    }

    @Override
    public SingnleBulder setSingleText(int id, String text, SingleListener lisener) {
        this.singleBtnIdRes = id;
        this.singleText = text;
        this.mSingleListener = lisener;
        return this;
    }

    @Override
    public SingnleBulder setSingleText(String text) {
        this.singleText = text;
        return this;
    }

    @Override
    public SingnleBulder setSingleId(int idRes) {
        this.singleBtnIdRes = idRes;
        return this;
    }

    @Override
    public SingnleBulder keepState(boolean state) {
        this.keepState = state;
        return this;
    }

    @Override
    public SingnleBulder setSingleBackground(int bgRes) {
        this.singleBackground = bgRes;
        return this;
    }

    @Override
    public SingnleBulder setSingleLisener(SingleListener lisener) {
        this.mSingleListener = lisener;
        return this;
    }

    @Override
    public SingnleBulder setBoldSingleText(boolean state) {
        this.singleBoldText = state;
        return this;
    }


    public interface SingleListener {
        void onSingleBtnClick(int requestCode);
    }
}
