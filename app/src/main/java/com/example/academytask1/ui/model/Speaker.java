package com.example.academytask1.ui.model;

public class Speaker {

    private int mId;
    private String mName;
    private String mOrigin;
    private String mShortDescription;
    private String mFullDescription;


    public Speaker(int id, String name, String city, String shortDescription, String fullDescription) {
        this.mId = id;
        this.mName = name;
        this.mOrigin = city;
        this.mShortDescription = shortDescription;
        this.mFullDescription = fullDescription;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getOrigin() {
        return mOrigin;
    }

    public void setOrigin(String mCity) {
        this.mOrigin = mCity;
    }

    public String getShortDescription() {
        return mShortDescription;
    }

    public void setShortDescription(String mShortDescription) {
        this.mShortDescription = mShortDescription;
    }

    public String getFullDescription() {
        return mFullDescription;
    }

    public void setFullDescription(String mFullDescription) {
        this.mFullDescription = mFullDescription;
    }
}
