package com.example.sweta.MyApplication;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by sweta on 3/16/18.
 */

public class application extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initRealm();
    }

    private void initRealm(){
        Realm.init( this);

        RealmConfiguration realmConfiguration=new RealmConfiguration.Builder()
                .schemaVersion(1).name("Helloworld").deleteRealmIfMigrationNeeded()
                .build();

        Realm.setDefaultConfiguration(realmConfiguration);
    }
}
