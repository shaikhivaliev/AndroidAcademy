package com.example.academytask1.ui.presentation.speaker;

import android.annotation.SuppressLint;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.academytask1.ui.AppDelegate;
import com.example.academytask1.ui.model.Repository;
import com.example.academytask1.ui.model.storage.SimpleDao;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class SpeakerPresenter extends MvpPresenter<SpeakerView> {

    Repository mRepository = new Repository();

    @SuppressLint("CheckResult")
    public void onGetSpeaker(String speakerId) {
        mRepository.getSpeaker(speakerId)
                .subscribe(
                        speaker -> getViewState().showSpeaker(speaker),
                        throwable -> getViewState().showError()
                );
    }
}
