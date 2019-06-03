package com.example.academytask1.ui;

import android.support.v4.app.Fragment;

import com.example.academytask1.ui.ui.devfest.DevFestFragment;
import com.example.academytask1.ui.ui.more.MoreFragment;
import com.example.academytask1.ui.ui.speakers.SpeakersFragment;
import com.example.academytask1.ui.ui.talks.TalksFragment;

import ru.terrakok.cicerone.Screen;
import ru.terrakok.cicerone.android.support.SupportAppScreen;

public class Screens {

    public static Screen SpeakersScreen = new SupportAppScreen() {
        @Override
        public Fragment getFragment() {
            return new SpeakersFragment();
        }
    };

    public static Screen TalksScreen = new SupportAppScreen() {
        @Override
        public Fragment getFragment() {
            return new TalksFragment();
        }
    };


    public static Screen DevFestScreen = new SupportAppScreen() {
        @Override
        public Fragment getFragment() {
            return new DevFestFragment();
        }
    };


    public static Screen MoreScreen = new SupportAppScreen() {
        @Override
        public Fragment getFragment() {
            return new MoreFragment();
        }
    };


}
