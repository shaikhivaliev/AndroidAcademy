package com.example.academytask1.ui.presentation.talks;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.example.academytask1.ui.entity.Talk;

import java.util.List;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface TalksView extends MvpView {

    void showTalks(List<Talk> talks);

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showError();

    void showProgress();

    void hideProgress();

}
