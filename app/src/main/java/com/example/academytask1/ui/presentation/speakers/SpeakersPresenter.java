package com.example.academytask1.ui.presentation.speakers;


import android.annotation.SuppressLint;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.academytask1.ui.AppDelegate;
import com.example.academytask1.ui.model.storage.SimpleDao;


import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class SpeakersPresenter extends MvpPresenter<SpeakersView> {

    @SuppressLint("CheckResult")
    public void onGetLocalData() {

        SimpleDao mSimpleDao = AppDelegate.getInstance().getDatabase().getDao();

        //todo показывать прогресс

        mSimpleDao.getSpeakers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        speakers -> getViewState().showSpeakers(speakers),
                        throwable -> getViewState().showError()
                );
    }
}
