package com.example.sweta.ViewPager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.sweta.NCCS.R;

/**
 * Created by sweta on 3/14/18.
 */

public class DemoActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnClicked, btnSecond;
    FrameLayout frameLayout;
    ViewPager pagerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        initActivity();
        setAdapter();
        setListener();
    }

    private void initActivity() {
        btnClicked = findViewById(R.id.btnClick);
        frameLayout = findViewById(R.id.frameFragment);
        btnSecond = findViewById(R.id.btnSecond);
        pagerView = findViewById(R.id.viewPager);

    }
    private void setAdapter(){
        MyViewPageAdapter myViewPageAdapter=new MyViewPageAdapter(getSupportFragmentManager());
        pagerView.setAdapter(myViewPageAdapter);
    }

    private void setListener() {
        btnClicked.setOnClickListener(this);
        btnSecond.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view == btnClicked) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frameFragment, new FragmentActivity())
                    .commit();
        } else if (view == btnSecond) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frameFragment, new SecondFragment())
                    .commit();
        }
    }
}
