package com.example.sweta.signingin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.StyleRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sweta.signingin.MyActivities.MainActivity;

public class SigninActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView signup, forgotPassword;
    private EditText username, password;
    private Button signin;
    private String usernameString, passwordString;
    private String myUsername = "sweta";
    private String myPassword = "sweta123";

    private int mThemeId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);


        findView();
        onClickListener();


    }

    public void setTheme(@StyleRes final int resid) {
        super.setTheme(resid);
        // Keep hold of the theme id so that we can re-set it later if needed
        mThemeId = resid;
    }

    public void findView() {
        signup = findViewById(R.id.signup);
        forgotPassword = findViewById(R.id.forgetPassword);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        signin = findViewById(R.id.signinbtn);
    }

    public void onClickListener() {

        signup.setOnClickListener(this);
        signin.setOnClickListener(this);
        forgotPassword.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.signinbtn:
                usernameString = username.getText().toString().trim();
                Log.i("username", usernameString);

                if (usernameString.equals("")) {
                    Toast.makeText(this, "Username cannot be empty", Toast.LENGTH_SHORT).show();
                } else {
                    passwordString = password.getText().toString();
                    Log.i("password", passwordString);
                    if (passwordString.equals("")) {
                        Toast.makeText(this, "Password cannot be empty", Toast.LENGTH_SHORT).show();
                    } else {
                        /*Toast.makeText(this, "Log in Sucessful", Toast.LENGTH_SHORT).show();*/
                        if (usernameString.equals(myUsername) && passwordString.equals(myPassword)) {

                            startLogInActivity();

                            Intent intent = new Intent(SigninActivity.this, MainActivity.class);
                            intent.putExtra("Intent", "This is my intent");
                            startActivity(intent);
                        } else {
                            Toast.makeText(this, "Username or password is incorrect", Toast.LENGTH_SHORT).show();
                        }

                    }
                }


                break;

            case R.id.signup:

                Intent intent = new Intent(SigninActivity.this, SignUpActivity.class);
                intent.putExtra("Intent", "This is my intent");
                startActivity(intent);
                break;

            case R.id.forgetPassword:
                Intent intent1 = new Intent(SigninActivity.this, ForgotPasswordActivity.class);
                startActivity(intent1);
                break;

            default:
                break;

        }

    }

    private void startLogInActivity() {
        SharedPreferences sharedPreferences =
                PreferenceManager.getDefaultSharedPreferences(this);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("IsLoggedIn", true);
        editor.apply();
    }
}
