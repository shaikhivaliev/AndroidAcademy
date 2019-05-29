package com.example.academytask1.ui.presentation.talks;


import android.annotation.SuppressLint;

import com.example.academytask1.ui.AppDelegate;
import com.example.academytask1.ui.model.storage.SimpleDao;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class TalksPresenter {

    private TalksView mTalksView;

    public TalksPresenter(TalksView mTalksView) {
        this.mTalksView = mTalksView;
    }

    @SuppressLint("CheckResult")
    public void onGetTalks() {

        SimpleDao mSimpleDao = AppDelegate.getInstance().getDatabase().getDao();

        //todo показывать прогресс

        mSimpleDao.getTalks()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        talks -> {
                            if (talks.size() != 0) {
                                mTalksView.showTalks(talks);
                            }
                        },
                        throwable -> mTalksView.showError()
                );
    }
}

