package com.example.sweta.signingin.MyActivities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.sweta.signingin.R;
import com.example.sweta.signingin.SigninActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView myRecyclerView;
    private MyAdapter myAdapter;
    List<Student> nameArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        Boolean isLoggedIn = sharedPreferences.getBoolean("IsLoggedIn", false);

        initActivity();
        initRecyclerView();
    }
    private void initActivity() {

        myRecyclerView = findViewById(R.id.recyclerView);
    }

    private void initRecyclerView() {
        myRecyclerView.setLayoutManager(new LinearLayoutManager(
                this, LinearLayoutManager.VERTICAL, false));

        nameArray = new ArrayList<>();

        Student student = new Student("Ram", 1);
        nameArray.add(student);

        Student student1 = new Student("Shyam", 2);
        nameArray.add(student1);

        Student student2 = new Student("Sita", 3);
        nameArray.add(student2);

        Student student3 = new Student("Gita", 4);
        nameArray.add(student3);

        Student student4 = new Student("Hari", 5);
        nameArray.add(student4);

        Student student5 = new Student("Ram Bahadur", 6);
        nameArray.add(student5);

        Student student6 = new Student("SitaRam", 7);
        nameArray.add(student6);

        Student student7 = new Student("HariRam", 8);
        nameArray.add(student7);

        Student student8 = new Student("Shyam Bahadur", 9);
        nameArray.add(student8);

        Student student9 = new Student("Mita", 10);
        nameArray.add(student9);


        myAdapter = new MyAdapter(nameArray);
        myRecyclerView.setAdapter(myAdapter);
    }


}
