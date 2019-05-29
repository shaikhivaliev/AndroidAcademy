package com.example.academytask1.ui.presentation.speaker;

import com.arellomobile.mvp.MvpView;
import com.example.academytask1.ui.entity.Speaker;

public interface SpeakerView extends MvpView {

    void showSpeaker(Speaker speaker);

    void showError();

    void showProgress();

    void hideProgress();

}
