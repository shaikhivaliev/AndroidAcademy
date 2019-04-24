package com.example.academytask1.ui.di;

import com.example.academytask1.ui.ui.event.FragmentEventList;
import com.example.academytask1.ui.ui.speaker.FragmentSpeakerList;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class})

public interface AppComponent {

    void inject(FragmentEventList fragmentEventList);

    void inject(FragmentSpeakerList fragmentSpeakerList);

}
