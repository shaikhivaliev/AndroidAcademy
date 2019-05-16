package com.example.academytask1.ui.entity;

import com.google.gson.annotations.SerializedName;

public class Links {

    @SerializedName("twitter")
    private String mTwitterLink;

    @SerializedName("ic_github")
    private String mGithubLink;

    public Links(String mTwitterLink, String mGithubLink) {
        this.mTwitterLink = mTwitterLink;
        this.mGithubLink = mGithubLink;
    }

    public String getTwitterLink() {
        return mTwitterLink;
    }

    public void setTwitterLink(String mTwitterLink) {
        this.mTwitterLink = mTwitterLink;
    }

    public String getGithubLink() {
        return mGithubLink;
    }

    public void setGithubLink(String mGithubLink) {
        this.mGithubLink = mGithubLink;
    }
}
