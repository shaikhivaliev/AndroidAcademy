package com.example.academytask1.ui.presentation.speaker;

import com.example.academytask1.ui.entity.Speaker;
import com.example.academytask1.ui.model.LocalCallback;
import com.example.academytask1.ui.model.LocalData;

public class SpeakerCallbackPresenter implements LocalCallback.SpeakerCallback {

    private SpeakerView mSpeakerView;
    private LocalData mLocalData = new LocalData();

    public SpeakerCallbackPresenter(SpeakerView mSpeakerView) {
        this.mSpeakerView = mSpeakerView;
        mLocalData.setCallbackSpeaker(this);
    }

    public void onGetSpeaker(String speakerId) {
        mLocalData.getSpeaker(speakerId);
    }

    @Override
    public void showDetailSpeaker(Speaker speaker) {
        mSpeakerView.showSpeaker(speaker);
    }

    @Override
    public void showError() {
        mSpeakerView.showError();
    }

    @Override
    public void showProgress() {
        mSpeakerView.showProgress();
    }

    @Override
    public void hideProgress() {
        mSpeakerView.hideProgress();
    }
}
