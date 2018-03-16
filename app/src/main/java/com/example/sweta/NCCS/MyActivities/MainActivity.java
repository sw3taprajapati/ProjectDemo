package com.example.sweta.NCCS.MyActivities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.sweta.NCCS.R;
import com.example.sweta.NCCS.SigninActivity;
import com.example.sweta.NCCS.Utils.PreferenceUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView myRecyclerView;
    private MyAdapter myAdapter;
    List<Student> nameArray;
    Button logout;
    private Toolbar toolbar;
    private ProgressBar progressBar;
    private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        Boolean isLoggedIn = sharedPreferences.getBoolean("IsLoggedIn", false);

        initActivity();
        initRecyclerView();
        onClickListener();
        initToolbar();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.GONE);
                relativeLayout.setVisibility(View.VISIBLE);
            }
        },2000);
    }
    private void initActivity() {

        myRecyclerView = findViewById(R.id.recyclerView);
        logout=findViewById(R.id.btnLogout);
        toolbar=findViewById(R.id.toolBarInclude);
        progressBar=findViewById(R.id.progressBarMy);
        relativeLayout=findViewById(R.id.relativeLayoutView);
    }

    private void initToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Welcome to NCCS");
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

    private void onClickListener(){
        logout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.btnLogout:

                //default Dialog Box
               /* AlertDialog.Builder builder=new AlertDialog.Builder(this);


                builder.setTitle("Log Out?");
                builder.setMessage("Are you sure you want to log out?");

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        PreferenceUtils.startLogInActivity(MainActivity.this,false);
                        Intent intent = new Intent(MainActivity.this, SigninActivity.class);
                        startActivity(intent);
                        finish();
                        dialogInterface.dismiss();
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog dialog=builder.create();
                dialog.show();*/


               //Customize Dialog Box

                AlertDialog.Builder builder=new AlertDialog.Builder(this);

                LayoutInflater inflater=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;

                View view1=inflater.inflate(R.layout.dialog_custom,null);

                builder.setView(view1);

                final AlertDialog dialog=builder.create();

                TextView textViewClass=view.findViewById(R.id.textView);
                Button yesBtn=view1.findViewById(R.id.btnYes);
                Button noBtn=view1.findViewById(R.id.btnNo);

                yesBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        PreferenceUtils.startLogInActivity(MainActivity.this,false);
                        Intent intent = new Intent(MainActivity.this, SigninActivity.class);
                        startActivity(intent);
                        finish();
                        dialog.dismiss();
                    }
                });

                noBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
                break;

            default:
                break;
        }
    }
}
