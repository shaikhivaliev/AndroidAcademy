package com.example.academytask1.ui.presentation.speakers;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.example.academytask1.ui.entity.Speaker;

import java.util.List;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface SpeakersView extends MvpView {

    void showSpeakers(List<Speaker> speakers);

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showError();

    void showProgress();

    void hideProgress();

}
