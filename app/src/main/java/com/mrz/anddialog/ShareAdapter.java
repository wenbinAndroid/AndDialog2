package com.mrz.anddialog;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;



public class ShareAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    private int[] shareRes = new int[]{R.mipmap.ic_share_circle, R.mipmap.ic_share_wechat, R
            .mipmap.ic_share_qq, R.mipmap.ic_share_qzone};

    public ShareAdapter(@Nullable List<String> data) {
        super(R.layout.item_share_view, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setImageResource(R.id.iv, shareRes[helper.getLayoutPosition()]).setText(R.id.tv,
                item);
    }
}
