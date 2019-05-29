package com.example.academytask1.ui.presentation.speakers;

import com.arellomobile.mvp.MvpView;
import com.example.academytask1.ui.entity.Speaker;

import java.util.List;

public interface SpeakersView extends MvpView {

    void showSpeakers(List<Speaker> speakers);

    void showError();

    void showProgress();

    void hideProgress();

}
