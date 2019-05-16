package com.example.academytask1.ui.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Event implements Serializable {

    @SerializedName("id")
    private int mEventId;

    @SerializedName("title")
    private String mTitle;

    @SerializedName("description")
    private String mDescription;

    @SerializedName("room")
    private int mRoom;

    @SerializedName("track")
    private String mTrack;

    @SerializedName("speaker")
    private String mSpeaker;

    @SerializedName("time")
    private String mTime;

    public Event(int mEventId, String mTitle, String mDescription, int mRoom, String mTrack, String mSpeaker, String mTime) {
        this.mEventId = mEventId;
        this.mTitle = mTitle;
        this.mDescription = mDescription;
        this.mRoom = mRoom;
        this.mTrack = mTrack;
        this.mSpeaker = mSpeaker;
        this.mTime = mTime;
    }

    public int getEventId() {
        return mEventId;
    }

    public void setEventId(int mEventId) {
        this.mEventId = mEventId;
    }

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
