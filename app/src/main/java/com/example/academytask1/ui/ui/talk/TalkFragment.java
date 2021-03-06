package com.example.academytask1.ui.ui.talk;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatDialogFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.academytask1.R;
import com.example.academytask1.ui.entity.Talk;
import com.example.academytask1.ui.presentation.talk.TalkPresenter;
import com.example.academytask1.ui.presentation.talk.TalkView;

public class TalkFragment extends MvpAppCompatDialogFragment implements TalkView {

    public static final String EVENTID = "EVENTID";

    private String mEventId;
    private TextView mEventTitle;
    private TextView mEventTrack;
    private TextView mEventSpeaker;
    private TextView mEventDescription;

    @InjectPresenter
    public TalkPresenter mPresenter;

    public static TalkFragment newInstance(Bundle args) {

        TalkFragment fragment = new TalkFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mEventId = getArguments().getString(EVENTID);
        }
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_talk_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mEventTitle = view.findViewById(R.id.tv_event_detail_name);
        mEventTrack = view.findViewById(R.id.tv_event_detail_tag);
        mEventSpeaker = view.findViewById(R.id.tv_event_detail_speaker_name);
        mEventDescription = view.findViewById(R.id.tv_event_detail_summary);

        mPresenter.onGetEvent(mEventId);

    }

    @Override
    public void showTalk(Talk talk) {
        mEventTitle.setText(talk.getTitle());
        mEventTrack.setText(talk.getTrack());
        mEventSpeaker.setText(talk.getSpeaker());
        mEventDescription.setText(talk.getDescription());
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
