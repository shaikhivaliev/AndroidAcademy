package com.example.academytask1.ui.presentation.talk;


import android.annotation.SuppressLint;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.academytask1.ui.AppDelegate;
import com.example.academytask1.ui.model.storage.SimpleDao;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class TalkPresenter extends MvpPresenter<TalkView> {

    @SuppressLint("CheckResult")
    public void onGetEvent(String talkId) {

        SimpleDao mSimpleDao = AppDelegate.getInstance().getDatabase().getDao();

        mSimpleDao.getTalkById(talkId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        talk -> getViewState().showTalk(talk),
                        throwable -> getViewState().showError()
                );


    }

}
