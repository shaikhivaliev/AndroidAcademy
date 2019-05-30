package com.example.academytask1.ui.ui.speakers;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.academytask1.R;
import com.example.academytask1.ui.OnItemClickListener;
import com.example.academytask1.ui.entity.Speaker;
import com.example.academytask1.ui.presentation.speakers.SpeakersPresenter;
import com.example.academytask1.ui.presentation.speakers.SpeakersView;
import com.example.academytask1.ui.ui.speaker.SpeakerFragment;

import java.util.List;

public class SpeakersFragment extends MvpAppCompatFragment implements
        OnItemClickListener,
        SpeakersView {

    private RecyclerView mRecyclerView;
    private SpeakersAdapter mAdapter;
    private ProgressBar mProgressBar;

    @InjectPresenter
    public SpeakersPresenter mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_speaker_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = view.findViewById(R.id.rv_speakers);
        mProgressBar = view.findViewById(R.id.pb_download_speaker);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mAdapter = new SpeakersAdapter();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter.setListener(this);
        mRecyclerView.setAdapter(mAdapter);

        mPresenter.onGetLocalData();
    }


    @Override
    public void showSpeakers(List<Speaker> speakers) {
        mAdapter.addData(speakers);
    }

    @Override
    public void showError() {
        Toast.makeText(getActivity(), "Ошибка", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress() {
        mRecyclerView.setVisibility(View.GONE);
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mRecyclerView.setVisibility(View.VISIBLE);
        mProgressBar.setVisibility(View.GONE);
    }

    @Override

    public void itemClick(String id) {

        //todo заменить на Cicerone

        Bundle args = new Bundle();
        args.putString(SpeakerFragment.SPEAKERID, id);

        FragmentManager fm = getActivity().getSupportFragmentManager();
        SpeakerFragment speakerDetail = SpeakerFragment.newInstance(args);
        speakerDetail.setStyle(DialogFragment.STYLE_NO_TITLE, 0);
        speakerDetail.show(fm, "fragment_speaker_detail");


    }
}
