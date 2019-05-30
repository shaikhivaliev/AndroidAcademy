package com.example.academytask1.ui.presentation.speaker;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.example.academytask1.ui.entity.Speaker;


@StateStrategyType(AddToEndSingleStrategy.class)
public interface SpeakerView extends MvpView {

    void showSpeaker(Speaker speaker);

    void showError();

    void showProgress();

    void hideProgress();

}
