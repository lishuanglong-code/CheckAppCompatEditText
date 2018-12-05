package com.lsl;


import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 实际检查输入内容的实现
 * <p>
 * creation time ：2018/12/4
 * author ：lishuanglong
 */
public class CheckImpl implements CheckAppCompatEditText.ICheck {

    @Override
    public boolean check(String str, String regex) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(str);
        return matcher.matches();
    }
}
