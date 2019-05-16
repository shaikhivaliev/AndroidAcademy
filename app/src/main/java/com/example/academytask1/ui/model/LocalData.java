package com.example.academytask1.ui.model;

import com.example.academytask1.ui.AppDelegate;
import com.example.academytask1.ui.JsonUtils;
import com.example.academytask1.ui.entity.Event;
import com.example.academytask1.ui.entity.Links;
import com.example.academytask1.ui.entity.Speaker;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class LocalData {

    private LocalCallback.SpeakersCallback mSpeakersCallback;
    private LocalCallback.EventsCallback mEventsCallback;
    private LocalCallback.SpeakerCallback mSpeakerCallback;
    private LocalCallback.EventCallback mEventCallback;


    public void setCallbackSpeakers(LocalCallback.SpeakersCallback callback) {
        this.mSpeakersCallback = callback;
    }

    public void setCallbackEvents(LocalCallback.EventsCallback callback) {
        this.mEventsCallback = callback;
    }

    public void setCallbackSpeaker(LocalCallback.SpeakerCallback callback) {
        this.mSpeakerCallback = callback;
    }

    public void setCallbackEvent(LocalCallback.EventCallback callback) {
        this.mEventCallback = callback;
    }


    public void getSpeakers() {

        Gson gson = new Gson();
        Type type = new TypeToken<List<Speaker>>() {
        }.getType();
        try {
            List<Speaker> speakers = gson.fromJson(JsonUtils.loadJSONFromAsset(AppDelegate.getInstance(), "speakers"), type);
            mSpeakersCallback.showSpeakers(speakers);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void getEvents() {
        Gson gson = new Gson();
        Type type = new TypeToken<List<Event>>() {
        }.getType();
        try {
            List<Event> events = gson.fromJson(JsonUtils.loadJSONFromAsset(AppDelegate.getInstance(), "schedules"), type);
            mEventsCallback.showEvents(events);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getSpeaker(String speakerId) {

        Links links = new Links("https://twitter.com/iamironz", "https://ic_github.com/terrakok");
        Speaker speaker = new Speaker("alex-efremenkov", "Александр", "Ефременков", "Москва, Россия", "System Android developer", "Яндекс.Такси", "Пишу код, смотрю в Android.", "https://devfest-spb.com/img/speakers/AlexanderEfremenkov.jpg", "ru", links);
        mSpeakerCallback.showDetailSpeaker(speaker);

    }

    public void getEvent(int eventId) {

        Event event = new Event(1, "Kotlin-friendly Annotation Processing", "Рекламируя вашему другу Kotlin, как замену Java, наверняка первым аргум....", 1, "android", "sergey-ryabov", "11:15");
        mEventCallback.showDetailEvent(event);
    }

}
