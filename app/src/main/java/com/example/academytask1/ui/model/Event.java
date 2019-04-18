package com.example.academytask1.ui.model;

public class Event {

    private int mId;
    private String mTime;
    private String mDate;
    private String mName;
    private String mPlace;
    private String mTag;
    private Speaker mSpeaker;
    private String mSummary;

    public Event(int id, String time, String name, String place, String tag, Speaker speaker, String date) {
        this.mId = id;
        this.mTime = time;
        this.mName = name;
        this.mPlace = place;
        this.mTag = tag;
        this.mSpeaker = speaker;
        this.mDate = date;
    }

    public Event(int id, String name, String tag, String place, String preview) {
        this.mId = id;
        this.mName = name;
        this.mTag = tag;
        this.mPlace = place;
        this.mSummary = preview;
    }

    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public String getTime() {
        return mTime;
    }

    public void setTime(String mTime) {
        this.mTime = mTime;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getPlace() {
        return mPlace;
    }

    public void setPlace(String mPlace) {
        this.mPlace = mPlace;
    }

    public String getTag() {
        return mTag;
    }

    public void setTag(String mTag) {
        this.mTag = mTag;
    }

    public Speaker getSpeaker() {
        return mSpeaker;
    }

    public void setSpeaker(Speaker mSpeaker) {
        this.mSpeaker = mSpeaker;
    }

    public String getSummary() {
        return mSummary;
    }

    public void setSummary(String mPreview) {
        this.mSummary = mPreview;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String mDate) {
        this.mDate = mDate;
    }
}
