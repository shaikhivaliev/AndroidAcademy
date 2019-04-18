package com.example.academytask1.ui.ui.speaker;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.academytask1.R;
import com.example.academytask1.ui.model.Speaker;
import com.example.academytask1.ui.ui.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class FragmentSpeakerList extends Fragment implements
        OnItemClickListener {

    private RecyclerView mRecyclerView;
    private RecyclerAdapterSpeaker mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_speaker_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = view.findViewById(R.id.rv_speakers);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mAdapter = new RecyclerAdapterSpeaker();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter.setListener(this);
        mRecyclerView.setAdapter(mAdapter);

        getSpeakers();
    }

    private void getSpeakers() {
        List<Speaker> speakers = new ArrayList<>();
        speakers.add(new Speaker(1, "Speaker name", "Speaker origin", "Speaker description", null));
        speakers.add(new Speaker(1, "Speaker name", "Speaker origin", "Speaker description", null));
        speakers.add(new Speaker(1, "Speaker name", "Speaker origin", "Speaker description", null));
        speakers.add(new Speaker(1, "Speaker name", "Speaker origin", "Speaker description", null));
        speakers.add(new Speaker(1, "Speaker name", "Speaker origin", "Speaker description", null));
        speakers.add(new Speaker(1, "Speaker name", "Speaker origin", "Speaker description", null));
        speakers.add(new Speaker(1, "Speaker name", "Speaker origin", "Speaker description", null));
        speakers.add(new Speaker(1, "Speaker name", "Speaker origin", "Speaker description", null));
        speakers.add(new Speaker(1, "Speaker name", "Speaker origin", "Speaker description", null));
        speakers.add(new Speaker(1, "Speaker name", "Speaker origin", "Speaker description", null));

        mAdapter.addData(speakers);
    }

    @Override
    public void itemClick(int speakerId) {

        Bundle args = new Bundle();
        args.putInt(FragmentSpeakerDetail.SPEAKERID, speakerId);

        FragmentManager fm = getActivity().getSupportFragmentManager();
        FragmentSpeakerDetail speakerDetail = FragmentSpeakerDetail.newInstance(args);
        speakerDetail.show(fm, "fragment_speaker_detail");
    }

}
