package com.example.academytask1.ui.presentation.event;

import android.widget.Toast;

import com.example.academytask1.ui.AppDelegate;
import com.example.academytask1.ui.entity.Event;
import com.example.academytask1.ui.model.LocalCallback;
import com.example.academytask1.ui.model.LocalData;

public class EventCallbackPresenter implements LocalCallback.EventCallback {

    private EventView mEventView;
    private LocalData mLocalData = new LocalData();

    public EventCallbackPresenter(EventView mEventView) {
        this.mEventView = mEventView;
        mLocalData.setCallbackEvent(this);
    }

    public void onGetEvent(String eventId) {
        mLocalData.getEvent(eventId);
    }


    @Override
    public void showDetailEvent(Event event) {
        mEventView.showEvent(event);
    }

    @Override
    public void showError() {
        mEventView.showError();
    }

    @Override
    public void showProgress() {
        mEventView.showProgress();
    }

    @Override
    public void hideProgress() {
        mEventView.hideProgress();
    }
}
