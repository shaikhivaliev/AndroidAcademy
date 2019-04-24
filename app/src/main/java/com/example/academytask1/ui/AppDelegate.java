package com.example.academytask1.ui;

import android.app.Application;

import com.example.academytask1.ui.di.AppComponent;
import com.example.academytask1.ui.di.DaggerAppComponent;
import com.example.academytask1.ui.di.NetworkModule;

public class AppDelegate extends Application {

    private static AppComponent sAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        sAppComponent = DaggerAppComponent.builder()
                .networkModule(new NetworkModule()).build();
    }

    public static AppComponent getAppComponent() {
        return sAppComponent;
    }

}
