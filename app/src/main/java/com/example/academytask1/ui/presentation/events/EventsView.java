package com.example.academytask1.ui.presentation.events;

import com.example.academytask1.ui.entity.Event;

import java.util.List;

public interface EventsView {

    void showEvents(List<Event> events);

    void showError();

    void showProgress();

    void hideProgress();

}
