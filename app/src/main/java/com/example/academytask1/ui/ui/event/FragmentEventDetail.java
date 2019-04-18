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
import com.example.academytask1.ui.model.Event;

public class FragmentEventDetail extends DialogFragment {

    public static final String EVENTID = "EVENTID";

    private int mEventId;
    private Event mEvent;
    private TextView mEventName;
    private TextView mEventTag;
    private TextView mEventPlace;
    private TextView mEventSummary;

    public static FragmentEventDetail newInstance(Bundle args) {

        FragmentEventDetail fragment = new FragmentEventDetail();
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

        mEventName = view.findViewById(R.id.tv_event_detail_name);
        mEventTag = view.findViewById(R.id.tv_event_detail_tag);
        mEventPlace = view.findViewById(R.id.tv_event_detail_speaker_name);
        mEventSummary = view.findViewById(R.id.tv_event_detail_summary);

        getEvent(mEventId);

    }


    private void getEvent(int eventId) {

        mEvent = new Event(1, "Event name", "Android", "Event place", "Event description");

        mEventName.setText(mEvent.getName());
        mEventTag.setText(mEvent.getTag());
        mEventPlace.setText(mEvent.getPlace());
        mEventSummary.setText(mEvent.getSummary());

    }

}
