package com.github.mrz.dialog.request;

import com.github.mrz.dialog.builder.CenterBuilder;

/**
 * @author Mrz
 * @date 2019/5/22 10:07
 */
public interface CenterRequest extends BaseRquest<CenterBuilder> {

    CenterBuilder setCenterListener(CenterBuilder.CenterListener listener);

}
