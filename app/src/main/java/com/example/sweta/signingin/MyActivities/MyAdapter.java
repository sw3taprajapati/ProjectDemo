package com.example.sweta.signingin.MyActivities;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sweta.signingin.R;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sweta on 3/4/18.
 */

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    List<Student> myNameList;

  public MyAdapter(List<Student> nameArray) {

      myNameList = nameArray;

  }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_my_recyclerview, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

      Student student=myNameList.get(position);
        holder.myName.setText(student.getName());
        holder.myRollNo.setText(student.getRollNo().toString());
        /*holder.myName.setText(nameArray[position].toString());
        holder.myRollNo.setText(rollArray[position]);
        position=position+1;*/
    }

    @Override
    public int getItemCount() {
        return myNameList.size();
//        return nameArray.length;
    }
}
