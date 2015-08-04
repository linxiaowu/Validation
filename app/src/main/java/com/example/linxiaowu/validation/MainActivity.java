package com.example.linxiaowu.validation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.throrinstudio.android.common.libs.validator.Form;
import com.throrinstudio.android.common.libs.validator.Validate;
import com.throrinstudio.android.common.libs.validator.validate.ConfirmValidate;
import com.throrinstudio.android.common.libs.validator.validate.OrTwoRequiredValidate;
import com.throrinstudio.android.common.libs.validator.validator.EmailValidator;
import com.throrinstudio.android.common.libs.validator.validator.NotEmptyValidator;
import com.throrinstudio.android.common.libs.validator.validator.NumOrLettersValidator;
import com.throrinstudio.android.common.libs.validator.validator.UrlValidator;


public class MainActivity extends Activity {
    private EditText edtNotEmpty;
    private EditText edtOr1;
    private EditText edtOr2;
    private EditText edtNotMail;
    private EditText edtNotPassword1;
    private EditText edtNotPassword2;
    private EditText edtUrl;

    private Form form;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        form = new Form();

        //非空验证
        Validate validateNotEmpty = new Validate(edtNotEmpty);
        NotEmptyValidator notEmptyValidator = new NotEmptyValidator(this);
        validateNotEmpty.addValidator(notEmptyValidator);

        //二选一
        OrTwoRequiredValidate orTwoRequiredValidate = new OrTwoRequiredValidate(edtOr1, edtOr2);


        //邮箱
        EmailValidator emailValidator = new EmailValidator(this);
        Validate emailValidate = new Validate(edtNotMail);
        emailValidator.setDomainName("gmail\\.com");
        emailValidate.addValidator(emailValidator);
        //确认密码
        ConfirmValidate confirmValidate = new ConfirmValidate(edtNotPassword1, edtNotPassword2);

        //匹配密码
        NumOrLettersValidator numOrLettersValidator = new NumOrLettersValidator(this);
        Validate numOrLettersValidate = new Validate(edtNotPassword1);
        numOrLettersValidate.addValidator(numOrLettersValidator);

        //网址
        UrlValidator urlValidator = new UrlValidator(this);
        Validate urlValidate = new Validate(edtUrl);
        urlValidate.addValidator(urlValidator);


        validateNotEmpty.addValidator(urlValidator);


        //把验证类放进表单里
        form.addValidates(validateNotEmpty);
        form.addValidates(orTwoRequiredValidate);
        form.addValidates(emailValidate);
        form.addValidates(confirmValidate);
        form.addValidates(urlValidate);
        form.addValidates(numOrLettersValidate);


    }

    private void init() {
        edtNotEmpty = (EditText) this.findViewById(R.id.editText_NotEmpty);
        edtOr1 = (EditText) this.findViewById(R.id.editText_or1);
        edtOr2 = (EditText) this.findViewById(R.id.editText_or2);
        edtNotMail = (EditText) this.findViewById(R.id.editText_email);
        edtNotPassword1 = (EditText) this.findViewById(R.id.editText_password1);
        edtNotPassword2 = (EditText) this.findViewById(R.id.editText_password2);
        edtUrl = (EditText) this.findViewById(R.id.editText_net);


        Button button = (Button) this.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                form.validate();
            }
        });


    }


}
