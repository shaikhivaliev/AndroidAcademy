package com.example.academytask1.ui.ui.speaker;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.academytask1.R;
import com.example.academytask1.ui.model.Event;
import com.example.academytask1.ui.model.Speaker;
import com.example.academytask1.ui.ui.event.FragmentEventDetail;

public class FragmentSpeakerDetail extends DialogFragment {

    public static final String SPEAKERID = "SPEAKERID";

    private FloatingActionButton mFab;
    private View mEvent;
    private Speaker speaker;
    private Event event;
    private int mSpeakerId;
    private TextView mSpeakerName;
    private TextView mSpeakerShortDescription;
    private TextView mSpeakerOrigin;
    private TextView mSpeakerFullDescription;
    private TextView mEventName;
    private TextView mEventPlace;
    private TextView mEventTag;
    private TextView mEventTime;
    private TextView mEventDate;

    public static FragmentSpeakerDetail newInstance(Bundle args) {

        FragmentSpeakerDetail fragment = new FragmentSpeakerDetail();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mSpeakerId = getArguments().getInt(SPEAKERID);
        }

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_speaker_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mSpeakerName = view.findViewById(R.id.tv_speaker_detail_name);
        mSpeakerShortDescription = view.findViewById(R.id.tv_speaker_detail_short_description);
        mSpeakerOrigin = view.findViewById(R.id.tv_speaker_detail_origin);
        mSpeakerFullDescription = view.findViewById(R.id.tv_speaker_detail_full_description);
        mEventName = view.findViewById(R.id.tv_speaker_detail_event_name);
        mEventPlace = view.findViewById(R.id.tv_speaker_detail_event_place);
        mEventTag = view.findViewById(R.id.speaker_detail_tag);
        mEventTime = view.findViewById(R.id.tv_speaker_detail_event_time);
        mEventDate = view.findViewById(R.id.tv_speaker_detail_event_date);
        mEvent = view.findViewById(R.id.iv_speaker_detail_background);
        mFab = view.findViewById(R.id.fab_speaker_detail);

        mEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentEventDetail eventDetail = new FragmentEventDetail();
                eventDetail.show(fm, "fragment_event_detail");
                getDialog().dismiss();

            }
        });

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });

        getDetailInformation(mSpeakerId);

    }

    private void getDetailInformation(int speakerId) {

        speaker = new Speaker(1, "Speaker name", "Speaker origin", "Speaker short description", "Speaker full description");
        event = new Event(1, "Time", "Event name", "Event place", "Tag", speaker, "date");

        mEventDate.setText(event.getDate());
        mEventTime.setText(event.getTime());
        mEventTag.setText(event.getPlace());
        mEventPlace.setText(event.getPlace());
        mEventName.setText(event.getName());
        mSpeakerFullDescription.setText(speaker.getFullDescription());
        mSpeakerOrigin.setText(speaker.getOrigin());
        mSpeakerShortDescription.setText(speaker.getShortDescription());
        mSpeakerName.setText(speaker.getName());

    }
}
