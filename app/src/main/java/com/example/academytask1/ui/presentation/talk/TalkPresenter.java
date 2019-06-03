package com.example.academytask1.ui.presentation.talk;


import android.annotation.SuppressLint;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.academytask1.ui.AppDelegate;
import com.example.academytask1.ui.entity.Talk;
import com.example.academytask1.ui.model.Repository;
import com.example.academytask1.ui.model.storage.SimpleDao;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class TalkPresenter extends MvpPresenter<TalkView> {

    private Repository mRepository = new Repository();

    @SuppressLint("CheckResult")
    public void onGetEvent(String talkId) {

        mRepository.getTalk(talkId)
                .subscribe(
                        talk -> getViewState().showTalk(talk),
                        throwable -> getViewState().showError()
                );
    }
}
