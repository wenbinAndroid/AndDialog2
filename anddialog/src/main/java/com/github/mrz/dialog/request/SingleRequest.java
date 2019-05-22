package com.github.mrz.dialog.request;

import android.support.annotation.IdRes;

import com.github.mrz.dialog.builder.SingnleBulder;

/**
 * @author Mrz
 * @date 2019/5/17 16:34
 */
public interface SingleRequest extends BaseRquest<SingnleBulder> {


    //title
    SingnleBulder setTitleText(int id, String title);

    SingnleBulder setTitleText(String title);

    SingnleBulder setTitleColor(String color);

    SingnleBulder setTitleColor(@IdRes int colorRes);

    SingnleBulder setTitleTextSize(int size);

    SingnleBulder setTitleTextId(int id);

    SingnleBulder setBoldTitleText(boolean state);


    //content
    SingnleBulder setContentText(String content);

    SingnleBulder setContentText(int id, String content);

    SingnleBulder setContentTextColor(String color);

    SingnleBulder setContentTextColor(@IdRes int color);

    SingnleBulder setContentTextSize(int size);

    SingnleBulder setContentId(int id);

    SingnleBulder setBoldContentText(boolean state);


    //single
    SingnleBulder setSingleTextSize(int size);

    SingnleBulder setSingleTextColor(@IdRes int colorRes);

    SingnleBulder setSingleTextColor(String color);

    SingnleBulder setSingleText(int id, String text);

    SingnleBulder setSingleText(int id, String text,SingnleBulder.SingleListener lisener);

    SingnleBulder setSingleId(int idRes);

    SingnleBulder setSingleText(String text);

    SingnleBulder keepState(boolean state);

    SingnleBulder setSingleBackground(int bgRes);

    SingnleBulder setSingleLisener(SingnleBulder.SingleListener lisener);


    SingnleBulder setBoldSingleText(boolean state);


}
