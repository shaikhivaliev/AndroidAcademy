package com.example.academytask1.ui.presentation.event;

import com.example.academytask1.ui.entity.Event;

import java.util.List;

public interface EventView {

    void showEvent(Event event);

    void showError();

    void showProgress();

    void hideProgress();

}
