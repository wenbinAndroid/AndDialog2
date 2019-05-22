package com.github.mrz.dialog.request;

import android.support.v4.app.DialogFragment;
import android.view.View;

/**
 * @author Mrz
 * @date 2019/5/22 17:37
 */
public interface OnDialogListener {
    void onDialogListener(View view, DialogFragment dialogFragment, int requestCode);
}
