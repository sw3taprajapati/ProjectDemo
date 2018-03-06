package com.example.sweta.signingin;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by sweta on 2/6/18.
 */

public class SignUpActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, AdapterView.OnItemSelectedListener, View.OnClickListener {

    private String var;
    EditText username, password, confirmPassword;
    RadioButton male, female, others;
    Spinner spinnerAge;
    Button signUp;
    ImageView imageViewer;
    private List<String> ageList;

    private String userNameText, passWordText, confirmPasswordTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        getViewsData();
        setListener();
        initSpinner();
        getIntentData();

    }

    public void getViewsData() {

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.rePassword);
        male = findViewById(R.id.btnMale);
        female = findViewById(R.id.btnFemale);
        others = findViewById(R.id.btnOther);
        spinnerAge = findViewById(R.id.age);
        signUp = findViewById(R.id.signup);
        imageViewer = findViewById(R.id.imgViewer);
    }

    public void getIntentData() {
        try {
            if (getIntent().getStringExtra("Intent") != null) {
                var = getIntent().getStringExtra("Intent");
                Log.i("Variable", var);

            }
        } catch (Exception e) {
            Intent intent = new Intent(SignUpActivity.this, SigninActivity.class);
            startActivity(intent);
        }
    }

    public void setListener() {
        male.setOnCheckedChangeListener(this);
        female.setOnCheckedChangeListener(this);
        others.setOnCheckedChangeListener(this);
        spinnerAge.setOnItemSelectedListener(this);
        signUp.setOnClickListener(this);
        imageViewer.setOnClickListener(this);

    }

    public void initSpinner() {
        ageList = new ArrayList<>();
        ageList.add("Age");
        ageList.add("1");
        ageList.add("2");
        ageList.add("3");

        ArrayAdapter<String> dataAdapter =
                /*new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, ageList);*/
                new ArrayAdapter<>(this, R.layout.spinner_layout, ageList);

        /*dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);*/

        spinnerAge.setAdapter(dataAdapter);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {

        if (compoundButton == male) {
            Toast.makeText(this, "Male Button Checked", Toast.LENGTH_SHORT).show();
            if (checked) {
                Log.d("Malebutton", "onCheckedChanged: Checked");
            } else {
                Log.d("Malebutton", "onCheckedChanged: Unchecked");
            }
        } else if (compoundButton == female) {
            if (checked) {
                Toast.makeText(this, "Male Button Checked", Toast.LENGTH_SHORT).show();
                Log.d("Femalebutton", "onCheckedChanged: Checked");
            } else {
                Log.d("Femalebutton", "onCheckedChanged: Unchecked");
            }
        } else if (compoundButton == others) {
            Toast.makeText(this, "Male Button Checked", Toast.LENGTH_SHORT).show();
            if (checked) {
                Log.d("Othersbutton", "onCheckedChanged: Checked");
            } else {
                Log.d("Othersbutton", "onCheckedChanged: Unchecked");
            }
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView /*spinner*/, View view, int position, long id) {
        if (position != 0) {
            String selectedValue = adapterView.getItemAtPosition(position).toString();
            Toast.makeText(this, selectedValue, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case (R.id.signup):

                userNameText = username.getText().toString().trim();
                if (userNameText.isEmpty()) {
                    /*Toast.makeText(this, "Username cannot be Empty", Toast.LENGTH_SHORT).show();*/
                    username.setError("Username cannot be empty");
                } else {
                    passWordText = password.getText().toString();

                    if (passWordText.isEmpty()) {
                        Toast.makeText(this, "Password cannot be Empty", Toast.LENGTH_SHORT).show();
                    } else {
                        confirmPasswordTxt = confirmPassword.getText().toString();

                        if (confirmPasswordTxt.isEmpty()) {
                            Toast.makeText(this, "Enter in confirm Password", Toast.LENGTH_SHORT).show();
                        } else {
                            if (passWordText.equals(confirmPasswordTxt)) {
                                Toast.makeText(this, "sign up sucessful", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(this, "password and Retype password incorrect", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }

            case (R.id.imgViewer):

                    /*Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://facebook.com"));
                    startActivity(intent);*/

                try {

                    getPackageManager().getPackageInfo("com.kiloo.subwaysurf", 0);
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/100004227693206/"));

                    startActivity(intent);
                } catch (Exception e) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/sw3taprajapati"));
                    startActivity(intent);
                }

            default:
                break;
        }

    }
}
