package com.example.sweta.signingin.MyActivities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
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
import android.widget.TextView;

import com.example.sweta.signingin.MyActivities.Utils.PreferenceUtils;
import com.example.sweta.signingin.R;
import com.example.sweta.signingin.SigninActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView myRecyclerView;
    private MyAdapter myAdapter;
    private Toolbar toolbar;
    private Button button;
    List<Student> nameArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        Boolean isLoggedIn = sharedPreferences.getBoolean("IsLoggedIn", false);

        initActivity();
        initToolbar();
        initRecyclerView();
        setListener();
    }

    private void initActivity() {

        myRecyclerView = findViewById(R.id.recyclerView);
        toolbar = findViewById(R.id.toolBarLayout);
        button=findViewById(R.id.LogoutButton);
    }

    private void setListener(){
        button.setOnClickListener(this);
    }

    private void initToolbar() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle("My");
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

    public void onBackPressed(){
        super.onBackPressed();
        finish();
    }


    @Override
    public void onClick(View view) {
        if (view == button) {
            //DefaultDialog
            /*AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle("Title");
            builder.setMessage("Are you sure you want to logout?");
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    PreferenceUtils.startLogInActivity(MainActivity.this, false);
                    Intent intent = new Intent(MainActivity.this, SigninActivity.class);
                    startActivity(intent);
                    onBackPressed();
                    dialogInterface.dismiss();
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            final AlertDialog dialog = builder.create();
            dialog.show(); */

            //customDialog

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(true);
            LayoutInflater inflater=(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View viewdialog=inflater.inflate(R.layout.dialog_custom,null);
            builder.setView(viewdialog);
            final AlertDialog alertDialog=builder.create();

            TextView txtTitle=viewdialog.findViewById(R.id.txtTitle);
            Button btnOk=viewdialog.findViewById(R.id.btnOk);
            Button btnCancel=viewdialog.findViewById(R.id.btnCancel);
            btnOk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    PreferenceUtils.startLogInActivity(MainActivity.this, false);
                    Intent intent = new Intent(MainActivity.this, SigninActivity.class);
                    startActivity(intent);
                    onBackPressed();
                    alertDialog.dismiss();

                }
            });

            btnCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    alertDialog.dismiss();
                }
            });
            alertDialog.show();

        }


    }
}
