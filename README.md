
# AndDialog
## 基于DialogFragment的封装
### 由于项目里面经常有用到一些弹框的提示,但是UI又不太喜欢MD的风格,就自己封装了这个库,采用链式的结构,使用起来也比较方便,可自定义布局,按钮,文件,动画,这个只是基础功能,后面还会继续修改,暂时就提供了3种简单的风格



#### 如何引用

``` 
Add it in your root build.gradle at the end of repositories:
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency
	dependencies {
	implementation 'com.github.wenbinAndroid:AndDialog2:V1.0.0'
	}
```
![photo](https://github.com/wenbinAndroid/AndDialog/blob/master/photo/S80802-16210796.gif)
### 使用方法  
#### 选择对话框

``` Java
 AndDialog.with(this).check()
                .setContentText(R.id.tv_check_message, "这里是内容")
                .setRightText(R.id.btn_check_enter, "确定1")
                .setLeftText(R.id.btn_check_cancel, "取消1")
                .setTitleText(R.id.tv_check_title, "这里是标题")
                .setLeftTextColor("#dddddd")
                .setRightTexColor("#dddddd")
                .setTitleColor("#dddddd")
                .setCanceledOnTouchOutside(true)
                .setCancelable(true)
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
        }).setLayout(R.layout.dialog_common_check).build().show(getSupportFragmentManager());
```

#### 底部弹框
```Java
AndDialog.with(this).bottom().setBottomListener(new BottomBuilder.BottomListener() {
            @Override
            public void onBottomListener(View view, int requesCode) {
                RecyclerView rv = view.findViewById(R.id.recycler);
                rv.setLayoutManager(new LinearLayoutManager(MainActivity.this,
                        LinearLayoutManager.HORIZONTAL, false));
                rv.setAdapter(new ShareAdapter(SHARE_TEXT));
            }
        }).setLayout(R.layout.dialog_share).build().show
                (getSupportFragmentManager());
```
 
#### 错误提示框
``` java
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
                }).build().show(getSupportFragmentManager());
   
```




