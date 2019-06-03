package com.example.academytask1.ui.presentation.main;

import android.annotation.SuppressLint;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.academytask1.ui.AppDelegate;
import com.example.academytask1.ui.entity.Speaker;
import com.example.academytask1.ui.entity.Talk;
import com.example.academytask1.ui.model.Repository;
import com.example.academytask1.ui.model.server.ApiUtils;
import com.example.academytask1.ui.model.storage.SimpleDao;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    Repository mRepository = new Repository();


    @SuppressLint("CheckResult")
    public void getData() {

        ApiUtils.getApiService().getResponse()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        response -> {
                            mRepository.insertSpeakers(response.getSpeakers());
                            mRepository.insertTalks(response.getScheduleResponse().getTalks());

                        }, throwable -> getViewState().showError()
                );
    }

}
