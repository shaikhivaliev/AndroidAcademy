package com.example.academytask1.ui.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity(tableName = "talks")
public class Talk implements Serializable {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "title")
    @SerializedName("title")
    private String mTitle="";

    @ColumnInfo(name = "description")
    @SerializedName("description")
    private String mDescription;

    @ColumnInfo(name = "room")
    @SerializedName("room")
    private int mRoom;

    @ColumnInfo(name = "track")
    @SerializedName("track")
    private String mTrack;

    @ColumnInfo(name = "speaker")
    @SerializedName("speaker")
    private String mSpeaker;

    @ColumnInfo(name = "time")
    @SerializedName("time")
    private String mTime;

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public int getRoom() {
        return mRoom;
    }

    public void setRoom(int mRoom) {
        this.mRoom = mRoom;
    }

    public String getTrack() {
        return mTrack;
    }

    public void setTrack(String mTrack) {
        this.mTrack = mTrack;
    }

    public String getSpeaker() {
        return mSpeaker;
    }

    public void setSpeaker(String mSpeaker) {
        this.mSpeaker = mSpeaker;
    }

    public String getTime() {
        return mTime;
    }

    public void setTime(String mTime) {
        this.mTime = mTime;
    }
}
