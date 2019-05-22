package com.github.mrz.dialog.request;

import com.github.mrz.dialog.builder.BottomBuilder;

/**
 * @author Mrz
 * @date 2019/5/22 10:06
 */
public interface BottomRequest extends BaseRquest<BottomBuilder> {
    BottomBuilder setDialogListener(OnDialogListener bottomListener);
}
