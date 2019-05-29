package com.example.academytask1.ui.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ScheduleResponse {

    @SerializedName("talks")
    private List<Talk> mTalks;

    public List<Talk> getTalks() {
        return mTalks;
    }

    public void setTalks(List<Talk> mTalks) {
        this.mTalks = mTalks;
    }
}
