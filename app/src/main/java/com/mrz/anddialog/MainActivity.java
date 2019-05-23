package com.mrz.anddialog;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.github.mrz.dialog.AndDialog;
import com.github.mrz.dialog.builder.CheckBuilder;
import com.github.mrz.dialog.builder.SingnleBulder;
import com.github.mrz.dialog.request.OnDialogListener;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final List<String> SHARE_TEXT = Arrays.asList("朋友圈", "微信好友", "QQ好友", "QQ空间");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onCheck(View view) {

        AndDialog.with(this).check()
                .setContentText(R.id.tv_check_message, "这里是内容")
                .setRightText(R.id.btn_check_enter, "确定1")
                .setLeftText(R.id.btn_check_cancel, "取消1")
                .setTitleText(R.id.tv_check_title, "这里是标题")
                .setLeftTextColor("#dddddd")
                .setRightTexColor("#dddddd")
                .setTitleColor("#dddddd")
                .setCancelable(true)
                .setKeepState(false)
                .setBoldTitleText(false)
                .setBoldContentText(false)
                .setBoldLeftText(false)
                .setBoldRightText(false)
                .setContentTextColor("#dddddd")
                .setLeftBtnListener(new CheckBuilder.LeftBtnListener() {
                    @Override
                    public void onLeftBtnClick(int requestCode) {
                        Toast.makeText(MainActivity.this, "left", Toast.LENGTH_SHORT).show();
                    }
                }).setRightBtnListener(new CheckBuilder.RightBtnListener() {

            @Override
            public void onRightBtnClick(int requestCode) {
                Toast.makeText(MainActivity.this, "right", Toast.LENGTH_SHORT).show();
            }
        }).setLayout(R.layout.dialog_common_check).build().show();

    }


    public void onBottom(View view) {
        AndDialog.with(this).bottom().setDialogListener(new OnDialogListener() {
            @Override
            public void onDialogListener(View view, DialogFragment dialogFragment, int
                    requestCode) {
                RecyclerView rv = view.findViewById(R.id.recycler);
                rv.setLayoutManager(new LinearLayoutManager(MainActivity.this,
                        LinearLayoutManager.HORIZONTAL, false));
                rv.setAdapter(new ShareAdapter(SHARE_TEXT));
            }


        }).setLayout(R.layout.dialog_share).build().show
                ();
    }


    public void onErr(View view) {
        AndDialog.with(this).single().setLayout(R.layout.dialog_common_tips).setTitleText(R.id
                .tv_tips_message, "这里是标题")
                .setBoldContentText(false)
                .setBoldSingleText(false)
                .setBoldTitleText(false)
                .setContentText(R.id.tv_tips_message, "错误了")
                .setSingleText(R.id.btn_tips_enter, "知道了")
                .setSingleLisener(new SingnleBulder.SingleListener() {
                    @Override
                    public void onSingleBtnClick(int requestCode) {

                    }
                }).build().show();
    }

}
