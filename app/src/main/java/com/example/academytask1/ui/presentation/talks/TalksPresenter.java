package com.example.academytask1.ui.presentation.talks;


import android.annotation.SuppressLint;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.academytask1.ui.AppDelegate;
import com.example.academytask1.ui.model.Repository;
import com.example.academytask1.ui.model.storage.SimpleDao;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


@InjectViewState
public class TalksPresenter extends MvpPresenter<TalksView> {

    Repository mRepository = new Repository();

    @SuppressLint("CheckResult")
    public void onGetTalks() {
        //todo показывать прогресс
        mRepository.getTalks()
                .subscribe(
                        talks -> getViewState().showTalks(talks),
                        throwable -> getViewState().showError()
                );
    }
}

