package com.example.academytask1.ui.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Speaker implements Serializable {

    @SerializedName("id")
    private String mSpeakerId;

    @SerializedName("firstName")
    private String mFirstName;

    @SerializedName("lastName")
    private String mLastName;

    @SerializedName("location")
    private String mLocation;

    @SerializedName("jobTitle")
    private String mJobTitle;

    @SerializedName("company")
    private String mCompany;

    @SerializedName("about")
    private String mAbout;

    @SerializedName("photo")
    private String photoUrl;

    @SerializedName("flagImage")
    private String mFlagImage;

    @SerializedName("links")
    private Links mLinks;

    public Speaker(String mSpeakerId, String mFirstName, String mLastName, String mLocation, String mJobTitle, String mCompany, String mAbout, String photoUrl, String mFlagImage, Links mLinks) {
        this.mSpeakerId = mSpeakerId;
        this.mFirstName = mFirstName;
        this.mLastName = mLastName;
        this.mLocation = mLocation;
        this.mJobTitle = mJobTitle;
        this.mCompany = mCompany;
        this.mAbout = mAbout;
        this.photoUrl = photoUrl;
        this.mFlagImage = mFlagImage;
        this.mLinks = mLinks;
    }


    public String getSpeakerId() {
        return mSpeakerId;
    }

    public void setSpeakerId(String mSpeakerId) {
        this.mSpeakerId = mSpeakerId;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String mFirstName) {
        this.mFirstName = mFirstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String mLastName) {
        this.mLastName = mLastName;
    }

    public String getLocation() {
        return mLocation;
    }

    public void setLocation(String mLocation) {
        this.mLocation = mLocation;
    }

    public String getJobTitle() {
        return mJobTitle;
    }

    public void setJobTitle(String mJobTitle) {
        this.mJobTitle = mJobTitle;
    }

    public String getCompany() {
        return mCompany;
    }

    public void setCompany(String mCompany) {
        this.mCompany = mCompany;
    }

    public String getAbout() {
        return mAbout;
    }

    public void setAbout(String mAbout) {
        this.mAbout = mAbout;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getFlagImage() {
        return mFlagImage;
    }

    public void setFlagImage(String mFlagImage) {
        this.mFlagImage = mFlagImage;
    }

    public Links getLinks() {
        return mLinks;
    }

    public void setLinks(Links mLinks) {
        this.mLinks = mLinks;
    }
}
