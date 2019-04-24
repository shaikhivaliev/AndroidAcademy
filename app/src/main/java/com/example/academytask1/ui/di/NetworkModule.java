package com.example.academytask1.ui.di;

import com.example.academytask1.ui.model.Event;
import com.example.academytask1.ui.model.Speaker;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class NetworkModule {

    @Singleton
    @Provides
    List<Event> provideEventList() {
        List<Event> events = new ArrayList<>();
        events.add(new Event(1, "Time", "Event name", "Event place", "Tag", new Speaker(1, "Speaker", "Moscow", "Speaker Description", null), "date"));
        events.add(new Event(1, "Time", "Event name", "Event place", "Tag", new Speaker(1, "Speaker", "Moscow", "Speaker Description", null), "date"));
        events.add(new Event(1, "Time", "Event name", "Event place", "Tag", new Speaker(1, "Speaker", "Moscow", "Speaker Description", null), "date"));
        events.add(new Event(1, "Time", "Event name", "Event place", "Tag", new Speaker(1, "Speaker", "Moscow", "Speaker Description", null), "date"));
        events.add(new Event(1, "Time", "Event name", "Event place", "Tag", new Speaker(1, "Speaker", "Moscow", "Speaker Description", null), "date"));
        events.add(new Event(1, "Time", "Event name", "Event place", "Tag", new Speaker(1, "Speaker", "Moscow", "Speaker Description", null), "date"));
        events.add(new Event(1, "Time", "Event name", "Event place", "Tag", new Speaker(1, "Speaker", "Moscow", "Speaker Description", null), "date"));
        events.add(new Event(1, "Time", "Event name", "Event place", "Tag", new Speaker(1, "Speaker", "Moscow", "Speaker Description", null), "date"));
        events.add(new Event(1, "Time", "Event name", "Event place", "Tag", new Speaker(1, "Speaker", "Moscow", "Speaker Description", null), "date"));
        events.add(new Event(1, "Time", "Event name", "Event place", "Tag", new Speaker(1, "Speaker", "Moscow", "Speaker Description", null), "date"));
        events.add(new Event(1, "Time", "Event name", "Event place", "Tag", new Speaker(1, "Speaker", "Moscow", "Speaker Description", null), "date"));
        return events;
    }
}
