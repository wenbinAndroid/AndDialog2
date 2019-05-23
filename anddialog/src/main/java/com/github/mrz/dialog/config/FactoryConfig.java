package com.github.mrz.dialog.config;

/**
 * @author Mrz
 * @date 2019/5/23 11:54
 */
public class FactoryConfig {
    private static float defaultWidthAttr = 0.75f;
    private static float defaultbackgroundDimAmount = 0.7f;

    public static float getDefaultWidthAttr() {
        return defaultWidthAttr;
    }

    public static float getDefaultbackgroundDimAmount() {
        return defaultbackgroundDimAmount;
    }

    public static boolean isDefaultCancelable() {
        return defaultCancelable;
    }

    public static boolean isDefaultCanceledOnTouchOutside() {
        return defaultCanceledOnTouchOutside;
    }

    private static boolean defaultCancelable = true;
    private static boolean defaultCanceledOnTouchOutside = false;

    public static void setDefaultCancelable(boolean default_cancelable) {
        FactoryConfig.defaultCancelable = default_cancelable;
    }

    public static void setDefaultCanceledOnTouchOutside(boolean default_canceledOnTouchOutside) {
        FactoryConfig.defaultCanceledOnTouchOutside = default_canceledOnTouchOutside;
    }

    public static void setWidthAttr(float widthAttr) {
        FactoryConfig.defaultWidthAttr = widthAttr;
    }
}
