package com.example.academytask1.ui.presentation.speakers;


import android.annotation.SuppressLint;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.academytask1.ui.AppDelegate;
import com.example.academytask1.ui.entity.Speaker;
import com.example.academytask1.ui.model.Repository;
import com.example.academytask1.ui.model.storage.SimpleDao;


import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class SpeakersPresenter extends MvpPresenter<SpeakersView> {

    Repository mRepository = new Repository();

    @SuppressLint("CheckResult")
    public void onGetLocalData() {
        //todo показывать прогресс

        mRepository.getSpeakers()
                .subscribe(
                        speakers -> getViewState().showSpeakers(speakers),
                        throwable -> getViewState().showError());

    }

}
