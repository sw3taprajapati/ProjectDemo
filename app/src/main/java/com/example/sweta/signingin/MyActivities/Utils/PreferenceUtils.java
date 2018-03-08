package com.example.sweta.signingin.MyActivities.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by somanjali on 3/8/18.
 */

public class PreferenceUtils {

    public static  void startLogInActivity(Context context,Boolean isLoggedIn) {
        SharedPreferences sharedPreferences =
                PreferenceManager.getDefaultSharedPreferences(context);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("IsLoggedIn", isLoggedIn);
        editor.apply();
    }
}
