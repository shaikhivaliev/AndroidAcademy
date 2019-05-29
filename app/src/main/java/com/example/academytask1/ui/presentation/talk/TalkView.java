package com.example.academytask1.ui.presentation.talk;

import com.arellomobile.mvp.MvpView;
import com.example.academytask1.ui.entity.Talk;

public interface TalkView extends MvpView {

    void showTalk(Talk talk);

    void showError();

    void showProgress();

    void hideProgress();

}
