package com.example.academytask1.ui.presentation.speaker;

import com.example.academytask1.ui.entity.Speaker;

public interface SpeakerView {

    void showSpeaker(Speaker speaker);

    void showError();

    void showProgress();

    void hideProgress();

}
