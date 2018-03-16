package com.example.sweta.ViewPager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by sweta on 3/15/18.
 */

public class MyViewPageAdapter extends FragmentStatePagerAdapter {
    public MyViewPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        if(position==0){
            return new FragmentActivity();
        }else if(position==1){
            return new SecondFragment();
        }else {
            return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {

        if(position==0){
            return "First Fragment";
        }else if(position==1){
            return  "Second Fragment";
        }else{
            return null;
        }
    }

    @Override

    public int getCount() {
        return 2;
    }
}
