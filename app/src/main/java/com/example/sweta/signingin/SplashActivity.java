package com.example.sweta.signingin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sweta.signingin.MyActivities.MainActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        final Boolean isLoggedIn = sharedPreferences.getBoolean("IsLoggedIn", false);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if (isLoggedIn) {


                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    //intent.putExtra("Intent", "This is my intent");
                    startActivity(intent);

                } else {


                    Intent intent = new Intent(SplashActivity.this, SigninActivity.class);
                    //intent.putExtra("Intent", "This is my intent");
                    startActivity(intent);


                }

            }
        },2000);


    }
}
