package com.example.academytask1.ui.presentation.talk;


import android.annotation.SuppressLint;

import com.example.academytask1.ui.AppDelegate;
import com.example.academytask1.ui.model.storage.SimpleDao;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class EventPresenter {

    private TalkView mTalkView;

    public EventPresenter(TalkView mTalkView) {
        this.mTalkView = mTalkView;
    }

    @SuppressLint("CheckResult")
    public void onGetEvent(String talkId) {

        SimpleDao mSimpleDao = AppDelegate.getInstance().getDatabase().getDao();

        mSimpleDao.getTalkById(talkId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        talk -> mTalkView.showTalk(talk),
                        throwable -> mTalkView.showError()
                );


    }

}
