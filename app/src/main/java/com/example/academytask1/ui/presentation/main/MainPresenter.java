package com.example.academytask1.ui.presentation.main;

import android.annotation.SuppressLint;
import android.util.Log;

import com.example.academytask1.ui.AppDelegate;
import com.example.academytask1.ui.entity.Speaker;
import com.example.academytask1.ui.entity.Talk;
import com.example.academytask1.ui.model.server.ApiUtils;
import com.example.academytask1.ui.model.storage.SimpleDao;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter {

    private MainView mView;

    public MainPresenter(MainView mView) {
        this.mView = mView;
    }


    @SuppressLint("CheckResult")
    public void getData() {

        SimpleDao mSimpleDao = AppDelegate.getInstance().getDatabase().getDao();

        ApiUtils.getApiService().getResponse()
                .subscribeOn(Schedulers.io())
                .doFinally(() -> mView.openSpeakersFragment())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        response -> {

                            List<Speaker> speakers = response.getSpeakers();
                            Completable.fromAction(() -> mSimpleDao.insertSpeakers(speakers))
                                    .subscribeOn(Schedulers.io())
                                    .subscribe();

                            List<Talk> talks = response.getScheduleResponse().getTalks();
                            Completable.fromAction(() -> mSimpleDao.insertTalks(talks))
                                    .subscribeOn(Schedulers.io())
                                    .subscribe();

                        }, throwable -> mView.showError()
                );
    }
}
