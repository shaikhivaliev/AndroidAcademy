package com.example.academytask1.ui;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.example.academytask1.ui.model.storage.AppDatabase;
import com.facebook.stetho.Stetho;


public class AppDelegate extends Application {

    public static AppDelegate instance;
    private AppDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(this, AppDatabase.class, "database")
                .build();

        // Create an InitializerBuilder
        Stetho.InitializerBuilder initializerBuilder =
                Stetho.newInitializerBuilder(this);
        // Enable Chrome DevTools
        initializerBuilder.enableWebKitInspector(
                Stetho.defaultInspectorModulesProvider(this)
        );
        // Use the InitializerBuilder to generate an Initializer
        Stetho.Initializer initializer = initializerBuilder.build();
        // Initialize Stetho with the Initializer
        Stetho.initialize(initializer);

    }

    public static AppDelegate getInstance() {
        return instance;
    }

    public AppDatabase getDatabase() {
        return database;
    }
}
