package com.example.sweta.NCCS;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by sweta on 2/6/18.
 */

public class ForgotPasswordActivity extends AppCompatActivity{

    private EditText username,newPassword,reEnteredPassword;
    private Button btnResetPassword;
    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);

        getViewData();
        initToolbar();
    }
    private void initToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Welcome to NCCS");
    }


    public void getViewData(){

        username=findViewById(R.id.username);
        newPassword=findViewById(R.id.newPassword);
        reEnteredPassword=findViewById(R.id.rePassword);
        btnResetPassword=findViewById(R.id.btnResetPassword);
        toolbar=findViewById(R.id.toolBarInclude);
    }
}
