# CheckAppCompatEditText
**一个检查输入内容的 AppCompatEditText 。（An AppCompatEditText that checks the input.）**
#### 功能详解：<br>1.实时对输入的内容进行检查。<br>2.输入完成后，最后检查内容。<br>3.当然前面两个功能也是可以一起使用的（这才是正常的使用场景）
#### 使用方法：<br>1.下载本项目导入module。<br>2.以依赖的方式添加到项目 <br>（project build.gradle）
```
allprojects {
        repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
#### (module build.gradle)
```
dependencies {
	implementation 'com.github.lishuanglong-code:CheckAppCompatEditText:v1.0.0'
}
```


#### 代码示例：<br>
```
<com.lsl.CheckAppCompatEditText
        android:id="@+id/et_check_text"
        android:layout_width="match_parent"
        android:layout_height="50dp"/>
        
CheckAppCompatEditText checkText = findViewById(R.id.et_check_text);

/**
* 设置正则表达式，设置实时检查输入，并用代码实现实时检查输入的结果回调
* */
checkText.setRegex("(^[^0][0-9]{3})-([0][1-9]|[1][0-2])-([0][1-9]|[1-2][0-9]|[3][0-1])")
         .setRealTimeCheck(true)
         .setRealTimeCheckResultListener(new CheckAppCompatEditText.RealTimeCheckResult() {
              @Override
              public void checkFailure() {
                  L.d(L.TAG, "checkFailure");
              }

              @Override
              public void checkSucceed() {
                   L.d(L.TAG, "checkSucceed");
              }
          });
          
boolean inputCheckResult = mCheckText.getInputCheckResult();
L.d(L.TAG, "getInputCheckResult --> " + inputCheckResult);
```

#### 使用中有任何问题都可以提 Issues，我也会不断完善 CheckAppCompatEditText，欢迎 Star，感谢你的支持！
<br>
<br>
<br>
<br>
