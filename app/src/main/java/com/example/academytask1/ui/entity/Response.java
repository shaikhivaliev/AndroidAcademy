package com.example.academytask1.ui.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Response implements Serializable {

    @SerializedName("speakers")
    private List<Speaker> mSpeakers;

    @SerializedName("schedule")
    private ScheduleResponse mScheduleResponse;

    public List<Speaker> getSpeakers() {
        return mSpeakers;
    }

    public void setSpeakers(List<Speaker> mSpeakers) {
        this.mSpeakers = mSpeakers;
    }

    public ScheduleResponse getScheduleResponse() {
        return mScheduleResponse;
    }

    public void setScheduleResponse(ScheduleResponse mScheduleResponse) {
        this.mScheduleResponse = mScheduleResponse;
    }
}
