package com.lsl;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

/**
 * 实时检查功能实现
 * <p>
 * creation time ：2018/12/4
 * author ：lishuanglong
 */
public class RealTimeCheck {

    private String regex = null;
    private CheckAppCompatEditText.ICheck mICheckMode;
    private TextView textView;
    private CheckAppCompatEditText.RealTimeCheckResult result;

    public RealTimeCheck(String regex, TextView textView, CheckAppCompatEditText.RealTimeCheckResult result) {
        this.regex = regex;
        this.textView = textView;
        this.result = result;
        mICheckMode = new CheckImpl();
    }

    public void setRealTimeCheckResult(CheckAppCompatEditText.RealTimeCheckResult result) {
        this.result = result;
    }

    public void startRealTimeCheck() {
        endRealTimeCheck();
        textView.addTextChangedListener(mTextWatcher);
    }

    private TextWatcher mTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            String input = editable.toString();
            if (!mICheckMode.check(input, regex)) {
                //失敗
                if (result != null) {
                    result.checkFailure();
                }
            } else {
                //成功
                if (result != null) {
                    result.checkSucceed();
                }
            }
        }
    };

    public void endRealTimeCheck() {
        textView.removeTextChangedListener(mTextWatcher);
    }
}
