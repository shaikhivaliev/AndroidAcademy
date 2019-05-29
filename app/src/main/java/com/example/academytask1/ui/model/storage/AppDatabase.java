package com.example.academytask1.ui.model.storage;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.academytask1.ui.entity.Speaker;
import com.example.academytask1.ui.entity.Talk;

@Database(entities = {Talk.class, Speaker.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract SimpleDao getDao();
}
