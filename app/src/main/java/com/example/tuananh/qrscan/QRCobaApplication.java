package com.example.tuananh.qrscan;

import android.content.Context;

import com.google.android.gms.ads.MobileAds;

import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

//import qrcoba.w3engineers.com.qrcoba.R;
import com.example.tuananh.qrscan.R;
import com.example.tuananh.qrscan.helpers.util.SharedPrefUtil;
import com.example.tuananh.qrscan.helpers.util.database.DatabaseUtil;

public class QRCobaApplication extends MultiDexApplication {

    private static QRCobaApplication sInstance;

    public static Context getContext() {
        return sInstance.getApplicationContext();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        SharedPrefUtil.init(getApplicationContext());
        DatabaseUtil.init(getApplicationContext());
        MobileAds.initialize(this, getString(R.string.admob_app_id));
    }
}
