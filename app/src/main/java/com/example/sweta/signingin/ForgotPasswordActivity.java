package com.example.sweta.signingin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by sweta on 2/6/18.
 */

public class ForgotPasswordActivity extends AppCompatActivity{

    EditText username,newPassword,reEnteredPassword;
    Button btnResetPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);

        getViewData();
    }

    public void getViewData(){

        username=findViewById(R.id.username);
        newPassword=findViewById(R.id.newPassword);
        reEnteredPassword=findViewById(R.id.rePassword);
        btnResetPassword=findViewById(R.id.btnResetPassword);
    }
}
