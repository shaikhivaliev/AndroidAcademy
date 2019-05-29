package com.example.academytask1.ui.presentation.talk;

import com.example.academytask1.ui.entity.Talk;

public interface TalkView {

    void showTalk(Talk talk);

    void showError();

    void showProgress();

    void hideProgress();

}
