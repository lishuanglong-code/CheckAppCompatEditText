package com.test.lsl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lsl.CheckAppCompatEditText;
import com.lsl.L;

public class MainActivity extends AppCompatActivity {

    private CheckAppCompatEditText mCheckText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCheckText = findViewById(R.id.et_check_text);

        //1. 完全通过xml设置正则表达式，设置实时检查输入，并用代码实现实时检查输入的结果回调
//        mCheckText.setRealTimeCheckResultListener(new CheckAppCompatEditText.RealTimeCheckResult() {
//            @Override
//            public void checkFailure() {
//                L.d(L.TAG,"checkFailure");
//            }
//
//            @Override
//            public void checkSucceed() {
//                L.d(L.TAG,"checkSucceed");
//            }
//        });

        //2.(推荐：逻辑清晰)完全使用代码设置正则表达式，设置实时检查输入，并用代码实现实时检查输入的结果回调
        mCheckText.setRegex(this.getResources().getString(R.string.qq_regex))
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

        /**
         * 获取检查输入内容结果
         * */
        findViewById(R.id.btn_check).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean inputCheckResult = mCheckText.getInputCheckResult();
                L.d(L.TAG, "xml --> getInputCheckResult --> " + inputCheckResult);
            }
        });

    }
}
