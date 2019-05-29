package com.example.academytask1.ui.presentation.speakers;


import android.annotation.SuppressLint;

import com.example.academytask1.ui.AppDelegate;
import com.example.academytask1.ui.model.storage.SimpleDao;


import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SpeakersPresenter {

    private SpeakersView mSpeakersView;

    public SpeakersPresenter(SpeakersView speakersView) {
        this.mSpeakersView = speakersView;
    }

    @SuppressLint("CheckResult")
    public void onGetLocalData() {

        SimpleDao mSimpleDao = AppDelegate.getInstance().getDatabase().getDao();

        //todo показывать прогресс

        mSimpleDao.getSpeakers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        speakers -> mSpeakersView.showSpeakers(speakers),
                        throwable -> mSpeakersView.showError()
                );
    }
}
