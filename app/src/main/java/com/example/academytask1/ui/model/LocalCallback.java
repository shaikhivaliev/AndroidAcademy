package com.example.academytask1.ui.model;

import com.example.academytask1.ui.entity.Event;
import com.example.academytask1.ui.entity.Speaker;

import java.util.List;

public interface LocalCallback {

    interface EventsCallback {

        void showEvents(List<Event> events);

        void showError();

        void showProgress();

        void hideProgress();
    }

    interface SpeakersCallback {

        void showSpeakers(List<Speaker> speakers);

        void showError();

        void showProgress();

        void hideProgress();

    }

    interface EventCallback {

        void showDetailEvent(Event event);

        void showError();

        void showProgress();

        void hideProgress();
    }

    interface SpeakerCallback {

        void showDetailSpeaker(Speaker speaker);

        void showError();

        void showProgress();

        void hideProgress();

    }


}
