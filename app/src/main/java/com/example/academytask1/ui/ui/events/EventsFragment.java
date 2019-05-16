package com.example.academytask1.ui.ui.events;

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
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.academytask1.R;
import com.example.academytask1.ui.OnItemClickListener;
import com.example.academytask1.ui.entity.Event;
import com.example.academytask1.ui.presentation.events.EventsCallbackPresenter;
import com.example.academytask1.ui.presentation.events.EventsView;
import com.example.academytask1.ui.ui.event.EventFragment;

import java.util.List;

public class EventsFragment extends Fragment implements
        OnItemClickListener,
        EventsView {

    private RecyclerView mRecyclerView;
    private EventsAdapter mAdapter;
    private ProgressBar mProgressBar;
    private EventsCallbackPresenter mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_event_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = view.findViewById(R.id.rv_events);
        mProgressBar = view.findViewById(R.id.pb_download_event);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mAdapter = new EventsAdapter();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter.setListener(this);
        mRecyclerView.setAdapter(mAdapter);

        mPresenter = new EventsCallbackPresenter(this);
        mPresenter.onGetEvents();
    }


    @Override
    public void itemClick(String eventId) {

        Bundle args = new Bundle();
        args.putString(EventFragment.EVENTID, eventId);

        FragmentManager fm = getActivity().getSupportFragmentManager();
        EventFragment eventDetail = EventFragment.newInstance(args);
        eventDetail.show(fm, "fragment_event_detail");
    }

    @Override
    public void showEvents(List<Event> events) {
        mAdapter.addData(events);
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


}
