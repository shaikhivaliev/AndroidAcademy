package com.example.academytask1.ui.presentation.events;

import com.example.academytask1.ui.entity.Event;
import com.example.academytask1.ui.model.LocalCallback;
import com.example.academytask1.ui.model.LocalData;

import java.util.List;

public class EventsCallbackPresenter implements LocalCallback.EventsCallback {

    private EventsView mEventsView;
    private LocalData mLocalData = new LocalData();

    public EventsCallbackPresenter(EventsView mEventsView) {
        this.mEventsView = mEventsView;
        mLocalData.setCallbackEvents(this);
    }

    public void onGetEvents() {
        mLocalData.getEvents();
    }


    @Override
    public void showEvents(List<Event> events) {
        mEventsView.showEvents(events);
    }

    @Override
    public void showError() {
        mEventsView.showError();
    }

    @Override
    public void showProgress() {
        mEventsView.showProgress();
    }

    @Override
    public void hideProgress() {
        mEventsView.hideProgress();
    }
}
