package com.test.lsl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lsl.CheckAppCompatEditText;
import com.lsl.L;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private CheckAppCompatEditText mCheckText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCheckText = findViewById(R.id.et_check_text);

        String str01 = "2018-01-01";
        String str02 = "2018-11-11";
        String str03 = "2018-12-21";
        String str04 = "2018-03-31";
        String str05 = "0018-03-31";
        String str06 = "2018-12-35";
        String str07 = "2018-15-30";

        List<String> list = new ArrayList<>();
        list.add(str01);
        list.add(str02);
        list.add(str03);
        list.add(str04);
        list.add(str05);
        list.add(str06);
        list.add(str07);

        Pattern compile = Pattern.compile("(^[^0][0-9]{3})-([0][1-9]|[1][0-2])-([0][1-9]|[1-2][0-9]|[3][0-1])");
        for (String str : list) {
            Matcher matcher = compile.matcher(str);
            L.d(L.TAG, "matcher.matches() --> " + matcher.matches() + " ,--> " + str);
        }

        /**
         * 设置正则表达式，设置实时检查输入，并用代码实现实时检查输入的结果回调
         * */
//        mCheckText.setRegex(this.getResources().getString(R.string.qq_regex))
//                .setRealTimeCheck(true)
//                .setRealTimeCheckResultListener(new CheckAppCompatEditText.RealTimeCheckResult() {
//                    @Override
//                    public void checkFailure() {
//                        L.d(L.TAG, "checkFailure");
//                    }
//
//                    @Override
//                    public void checkSucceed() {
//                        L.d(L.TAG, "checkSucceed");
//                    }
//                });

        /**
         * 获取检查输入内容结果
         * */
        findViewById(R.id.btn_check).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean inputCheckResult = mCheckText.getInputCheckResult();
                L.d(L.TAG, "getInputCheckResult --> " + inputCheckResult);
            }
        });

    }
}
