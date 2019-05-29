package com.example.academytask1.ui.presentation.talks;

import com.example.academytask1.ui.entity.Talk;

import java.util.List;

public interface TalksView {

    void showTalks(List<Talk> talks);

    void showError();

    void showProgress();

    void hideProgress();

}
