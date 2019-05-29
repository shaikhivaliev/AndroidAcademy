package com.example.academytask1.ui.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


@Entity(tableName = "speakers")
public class Speaker implements Serializable {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id_speaker")
    @SerializedName("id")
    private String mSpeakerId = "";

    @ColumnInfo(name = "firstName")
    @SerializedName("firstName")
    private String mFirstName;

    @ColumnInfo(name = "lastName")
    @SerializedName("lastName")
    private String mLastName;

    @ColumnInfo(name = "location")
    @SerializedName("location")
    private String mLocation;

    @ColumnInfo(name = "jobTitle")
    @SerializedName("jobTitle")
    private String mJobTitle;

    @ColumnInfo(name = "company")
    @SerializedName("company")
    private String mCompany;

    @ColumnInfo(name = "about")
    @SerializedName("about")
    private String mAbout;

    @ColumnInfo(name = "photo")
    @SerializedName("photo")
    private String photoUrl;

    @ColumnInfo(name = "flagImage")
    @SerializedName("flagImage")
    private String mFlagImage;


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


}
