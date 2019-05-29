package com.example.academytask1.ui.presentation.speaker;

import android.annotation.SuppressLint;

import com.example.academytask1.ui.AppDelegate;
import com.example.academytask1.ui.model.storage.SimpleDao;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SpeakerPresenter {

    private SpeakerView mSpeakerView;

    public SpeakerPresenter(SpeakerView mSpeakerView) {
        this.mSpeakerView = mSpeakerView;
    }

    @SuppressLint("CheckResult")
    public void onGetSpeaker(String speakerId) {

        SimpleDao mSimpleDao = AppDelegate.getInstance().getDatabase().getDao();

        mSimpleDao.getSpeakerById(speakerId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        speaker -> mSpeakerView.showSpeaker(speaker),
                        throwable -> mSpeakerView.showError()
                );
    }
}
