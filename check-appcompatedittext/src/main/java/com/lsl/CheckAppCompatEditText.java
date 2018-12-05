package com.lsl;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatEditText;
import android.text.TextUtils;
import android.util.AttributeSet;

/**
 * 检查 EditText 输入的内容。分为两种模式：
 * 1.实时对输入的内容进行检查，返回成功或者失败。
 * 2.全部填写完整后，最后在进行检查
 * <p>
 * creation time ：2018/12/4
 * author ：lishuanglong
 */
public class CheckAppCompatEditText extends AppCompatEditText {

    private String regex = null;
    private boolean mIsRealTimeCheck = false;
    private ICheck mICheckMode;
    private RealTimeCheckResult listener = null;
    private RealTimeCheck mRealTimeCheck;

    public CheckAppCompatEditText(Context context) {
        this(context, null);
    }

    public CheckAppCompatEditText(Context context, AttributeSet attrs) {
        this(context, attrs, android.support.v7.appcompat.R.attr.editTextStyle);
    }

    public CheckAppCompatEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    /**
     * 初始化获取属性等操作
     */
    private void init() {
        mICheckMode = new CheckImpl();
    }

    /**
     * 设置正则表达式
     */
    public CheckAppCompatEditText setRegex(String regex) {
        this.regex = regex;
        return this;
    }

    /**
     * 设置是否实时检查
     */
    public CheckAppCompatEditText setRealTimeCheck(boolean mIsRealTimeCheck) {
        this.mIsRealTimeCheck = mIsRealTimeCheck;
        realTimeCheck();
        return this;
    }

    /**
     * 开始实时检查输入
     */
    private void realTimeCheck() {
        mRealTimeCheck = new RealTimeCheck(regex, this, listener);
        if (mIsRealTimeCheck) {
            if (!TextUtils.isEmpty(regex)) {
                mRealTimeCheck.startRealTimeCheck();
            }
        } else {
            mRealTimeCheck.endRealTimeCheck();
        }
    }

    /**
     * 设置实时检查结果的监听
     */
    public CheckAppCompatEditText setRealTimeCheckResultListener(RealTimeCheckResult listener) {
        this.listener = listener;
        mRealTimeCheck.setRealTimeCheckResult(listener);
        return this;
    }

    /**
     * 获取检查结果
     */
    public boolean getInputCheckResult() {
        String input = this.getText().toString();
        return mICheckMode.check(input, regex);
    }

    /**
     * 实时检查输入的接口
     */
    public interface RealTimeCheckResult {
        void checkFailure();

        void checkSucceed();
    }

    /**
     * 实际用来检查的接口
     */
    public interface ICheck {
        boolean check(String str, String regex);
    }
}
