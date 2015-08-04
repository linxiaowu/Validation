package com.throrinstudio.android.common.libs.validator.validator;

import android.content.Context;

import com.example.linxiaowu.validation.R;
import com.throrinstudio.android.common.libs.validator.AbstractValidator;
import java.util.regex.Pattern;

/**
 *  匹配注册密码，只允许字母和数字。长度再6-18之间。
 */
public class NumOrLettersValidator extends AbstractValidator {

    private static final Pattern mPattern = Pattern.compile("^[0-9a-zA-Z]\\w{5,17}$");
    private int mErrorMessage = R.string.validator_num_or_letters;

    public NumOrLettersValidator(Context c) {
        super(c);
    }

    public NumOrLettersValidator(Context c, int errorMessage) {
        super(c);
        mErrorMessage = errorMessage;
    }

    @Override
    public boolean isValid(String value) {
        return mPattern.matcher(value).matches();
    }

    @Override
    public String getMessage() {
        return mContext.getString(mErrorMessage);
    }


}
