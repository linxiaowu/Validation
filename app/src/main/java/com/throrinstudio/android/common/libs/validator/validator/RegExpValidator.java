package com.throrinstudio.android.common.libs.validator.validator;

import java.util.regex.Pattern;

import android.content.Context;

import com.example.linxiaowu.validation.R;
import com.throrinstudio.android.common.libs.validator.AbstractValidator;
import com.throrinstudio.android.common.libs.validator.ValidatorException;

/**
 * This validator test value with custom Regex Pattern.
 */
public class RegExpValidator extends AbstractValidator {


    private Pattern mPattern;

    private int mErrorMessage = R.string.validator_regexp;

    public RegExpValidator(Context c) {
        super(c);
    }

    public RegExpValidator(Context c, int errorMessage) {
        super(c);
        mErrorMessage = errorMessage;
    }

    public void setPattern(String pattern){
        mPattern = Pattern.compile(pattern);
    }

    public void setPattern(Pattern pattern) {
        mPattern = pattern;
    }

    @Override
    public boolean isValid(String value) throws ValidatorException {
        if(mPattern != null){
            return mPattern.matcher(value).matches();
        }else{
            throw new ValidatorException("You can set Regexp Pattern first");
        }
    }

    @Override
    public String getMessage() {
        return mContext.getString(mErrorMessage);
    }
}
