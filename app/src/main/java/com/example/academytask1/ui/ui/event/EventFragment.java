package com.example.academytask1.ui.ui.event;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.academytask1.R;
import com.example.academytask1.ui.entity.Event;
import com.example.academytask1.ui.presentation.event.EventCallbackPresenter;
import com.example.academytask1.ui.presentation.event.EventView;

public class EventFragment extends DialogFragment implements EventView {

    public static final String EVENTID = "EVENTID";

    private int mEventId;
    private TextView mEventTitle;
    private TextView mEventTrack;
    private TextView mEventSpeaker;
    private TextView mEventDescription;

    private EventCallbackPresenter mPresenter;

    public static EventFragment newInstance(Bundle args) {

        EventFragment fragment = new EventFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mEventId = getArguments().getInt(EVENTID);
        }
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_event_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mEventTitle = view.findViewById(R.id.tv_event_detail_name);
        mEventTrack = view.findViewById(R.id.tv_event_detail_tag);
        mEventSpeaker = view.findViewById(R.id.tv_event_detail_speaker_name);
        mEventDescription = view.findViewById(R.id.tv_event_detail_summary);

        mPresenter = new EventCallbackPresenter(this);
        mPresenter.onGetEvent(mEventId);

    }

    @Override
    public void showEvent(Event event) {

        mEventTitle.setText(event.getTitle());
        mEventTrack.setText(event.getTrack());
        mEventSpeaker.setText(event.getSpeaker());
        mEventDescription.setText(event.getDescription());

    }

    @Override
    public void showError() {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }
}
