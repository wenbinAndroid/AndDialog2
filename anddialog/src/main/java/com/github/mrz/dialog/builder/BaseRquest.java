package com.github.mrz.dialog.builder;

/**
 * @author Mrz
 * @date 2019/5/17 20:21
 */
public interface BaseRquest<T> {

    T setLayout(int layout);

    T setStyle(int style);

    T setCancelable(boolean cancelable);

    T setWidthAttr(float widthAttr);

    T setRequestCode(int requestCode);


    T setCanceledOnTouchOutside(boolean canceledOnTouchOutside);

    T setBackgroundDimAmount(float count);


    T setWidth(int width);

    T setHeight(int height);

}
