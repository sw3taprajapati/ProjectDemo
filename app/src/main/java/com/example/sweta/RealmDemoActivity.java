package com.example.sweta;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.sweta.NCCS.R;
import com.example.sweta.Realm.MyPojo;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by sweta on 3/16/18.
 */

public class RealmDemoActivity extends AppCompatActivity {

    MyPojo myPojo;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realm_demo);

        myPojo=new MyPojo(1, "Sweta",31);

        initRealm();
        getRealm();

    }
    private void initRealm(){

        Realm realm= Realm.getDefaultInstance();

        realm.beginTransaction();

        realm.copyToRealmOrUpdate(myPojo);

        realm.commitTransaction();

        realm.close();
    }

    private void getRealm(){

        Realm realm= Realm.getDefaultInstance();

        RealmResults<MyPojo> myPojoRealmResults=realm.where(MyPojo.class).findAll();

        List<MyPojo> myList=realm.copyFromRealm(myPojoRealmResults);

    }
}

