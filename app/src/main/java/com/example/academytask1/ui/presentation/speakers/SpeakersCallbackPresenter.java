package com.example.academytask1.ui.presentation.speakers;

import com.example.academytask1.ui.entity.Speaker;
import com.example.academytask1.ui.model.LocalCallback;
import com.example.academytask1.ui.model.LocalData;

import java.util.List;

public class SpeakersCallbackPresenter implements LocalCallback.SpeakersCallback {

    private SpeakersView mSpeakersView;
    private LocalData mLocalData = new LocalData();

    public SpeakersCallbackPresenter(SpeakersView speakersView) {
        this.mSpeakersView = speakersView;
        mLocalData.setCallbackSpeakers(this);
    }

    public void onGetLocalData() {
        mLocalData.getSpeakers();
    }

    @Override
    public void showSpeakers(List<Speaker> speakers) {
        mSpeakersView.showSpeakers(speakers);
    }

    @Override
    public void showError() {
        mSpeakersView.showError();
    }

    @Override
    public void showProgress() {
        mSpeakersView.showProgress();
    }

    @Override
    public void hideProgress() {
        mSpeakersView.hideProgress();

    }

}
