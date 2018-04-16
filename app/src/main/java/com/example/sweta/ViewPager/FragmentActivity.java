package com.example.sweta.ViewPager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sweta.NCCS.R;

/**
 * Created by sweta on 3/14/18.
 */

public class FragmentActivity extends Fragment implements View.OnClickListener {

    TextView btnSwitch;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_fragment,container,false);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        initComponents();
        setListener();
    }

    private void initComponents() {
        btnSwitch = getActivity().findViewById(R.id.switchFragment);
    }

    private void setListener(){
        btnSwitch.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(view==btnSwitch){
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frameFragment, new SecondFragment())
                    .commit();
        }
    }
}
