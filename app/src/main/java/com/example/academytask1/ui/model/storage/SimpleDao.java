package com.example.academytask1.ui.model.storage;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.academytask1.ui.entity.Speaker;
import com.example.academytask1.ui.entity.Talk;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface SimpleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTalks(List<Talk> talks);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSpeakers(List<Speaker> speakers);

    @Query("SELECT * FROM talks")
    Single<List<Talk>> getTalks();

    @Query("SELECT * FROM speakers")
    Single<List<Speaker>> getSpeakers();

    @Query("SELECT * FROM speakers WHERE id_speaker = :id")
    Single<Speaker> getSpeakerById(String id);

    @Query("SELECT * FROM talks WHERE title = :id")
    Single<Talk> getTalkById(String id);



}
