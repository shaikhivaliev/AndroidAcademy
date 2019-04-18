package com.example.academytask1.ui.ui.event;

import android.content.Context;
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
import com.example.academytask1.ui.model.Event;
import com.example.academytask1.ui.model.Speaker;
import com.example.academytask1.ui.ui.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class FragmentEventList extends Fragment implements
        OnItemClickListener {

    private RecyclerView mRecyclerView;
    private RecyclerAdapterEvent mAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_event_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = view.findViewById(R.id.rv_events);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mAdapter = new RecyclerAdapterEvent();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter.setListener(this);
        mRecyclerView.setAdapter(mAdapter);

        getEvents();
    }

    private void getEvents() {

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

        mAdapter.addData(events);

    }


    @Override
    public void itemClick(int eventId) {

        Bundle args = new Bundle();
        args.putInt(FragmentEventDetail.EVENTID, eventId);

        FragmentManager fm = getActivity().getSupportFragmentManager();
        FragmentEventDetail eventDetail = FragmentEventDetail.newInstance(args);
        eventDetail.show(fm, "fragment_event_detail");


    }
}
