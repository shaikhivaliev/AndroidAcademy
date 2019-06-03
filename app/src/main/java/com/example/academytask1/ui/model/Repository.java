package com.example.academytask1.ui.model;



import com.example.academytask1.ui.AppDelegate;
import com.example.academytask1.ui.entity.Speaker;
import com.example.academytask1.ui.entity.Talk;
import com.example.academytask1.ui.model.storage.SimpleDao;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class Repository {

    private SimpleDao mSimpleDao = AppDelegate.getInstance().getDatabase().getDao();


    public void insertTalks(List<Talk> talks) {
        Completable.fromAction(() -> mSimpleDao.insertTalks(talks))
                .subscribeOn(Schedulers.io())
                .subscribe();
    }

    public void insertSpeakers(List<Speaker> speakers) {
        Completable.fromAction(() -> mSimpleDao.insertSpeakers(speakers))
                .subscribeOn(Schedulers.io())
                .subscribe();
    }

    public Single<List<Speaker>> getSpeakers() {
        return mSimpleDao.getSpeakers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<List<Talk>> getTalks() {
        return mSimpleDao.getTalks()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }

    public Single<Talk> getTalk(String talkId) {
        return mSimpleDao.getTalkById(talkId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<Speaker> getSpeaker(String speakerId) {
        return mSimpleDao.getSpeakerById(speakerId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }

}
