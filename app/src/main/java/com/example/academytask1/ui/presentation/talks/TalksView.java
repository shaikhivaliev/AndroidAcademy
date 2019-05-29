package com.example.academytask1.ui.presentation.talks;

import com.arellomobile.mvp.MvpView;
import com.example.academytask1.ui.entity.Talk;

import java.util.List;

public interface TalksView extends MvpView {

    void showTalks(List<Talk> talks);

    void showError();

    void showProgress();

    void hideProgress();

}
