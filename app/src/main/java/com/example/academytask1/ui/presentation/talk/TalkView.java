package com.example.academytask1.ui.presentation.talk;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.example.academytask1.ui.entity.Talk;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface TalkView extends MvpView {

    void showTalk(Talk talk);

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showError();

    void showProgress();

    void hideProgress();

}
