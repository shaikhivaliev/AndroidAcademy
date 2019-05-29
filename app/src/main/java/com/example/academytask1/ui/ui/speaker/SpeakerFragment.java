package com.example.academytask1.ui.ui.speaker;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatDialogFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.academytask1.R;
import com.example.academytask1.ui.entity.Speaker;
import com.example.academytask1.ui.presentation.speaker.SpeakerPresenter;
import com.example.academytask1.ui.presentation.speaker.SpeakerView;
import com.squareup.picasso.Picasso;

public class SpeakerFragment extends MvpAppCompatDialogFragment implements SpeakerView {

    public static final String SPEAKERID = "SPEAKERID";

    private String mSpeakerId;
    private ImageView mSpeakerPhoto;
    private TextView mFirstName;
    private TextView mLastName;
    private TextView mJobTitle;
    private TextView mLocation;
    private TextView mSpeakerAbout;
    private ImageView mTwitterLink;
    private ImageView mGithubLink;

    @InjectPresenter
    public SpeakerPresenter mPresenter;

    public static SpeakerFragment newInstance(Bundle args) {

        SpeakerFragment fragment = new SpeakerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mSpeakerId = getArguments().getString(SPEAKERID);
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

        mSpeakerAbout = view.findViewById(R.id.tv_speaker_detail_about);
        mFirstName = view.findViewById(R.id.tv_speaker_detail_first_name);
        mLastName = view.findViewById(R.id.tv_speaker_detail_second_name);
        mJobTitle = view.findViewById(R.id.tv_speaker_detail_job);
        mLocation = view.findViewById(R.id.tv_speaker_detail_location);
        mSpeakerPhoto = view.findViewById(R.id.iv_speaker_detail_photo);
        mTwitterLink = view.findViewById(R.id.iv_connect_with_twitter);
        mGithubLink = view.findViewById(R.id.iv_connect_with_github);

        mPresenter.onGetSpeaker(mSpeakerId);
    }

    @Override
    public void showSpeaker(Speaker speaker) {

        Picasso.get().load(speaker.getPhotoUrl()).into(mSpeakerPhoto);

        mFirstName.setText(speaker.getFirstName());
        mLastName.setText(speaker.getLastName());
        mLocation.setText(speaker.getLocation());
        mJobTitle.setText(speaker.getJobTitle());
        mSpeakerAbout.setText(speaker.getAbout());

/*
        mTwitterLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(speaker.getLinks().getTwitterLink()));
                startActivity(intent);
            }
        });

        mGithubLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(speaker.getLinks().getGithubLink()));
                startActivity(intent);
            }
        });
*/


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
