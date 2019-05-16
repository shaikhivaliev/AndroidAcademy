package com.example.academytask1.ui.presentation.speakers;

import com.example.academytask1.ui.entity.Speaker;

import java.util.List;

public interface SpeakersView {

    void showSpeakers(List<Speaker> speakers);

    void showError();

    void showProgress();

    void hideProgress();

}
