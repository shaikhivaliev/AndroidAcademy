package com.example.academytask1.ui.ui.event;

import android.os.AsyncTask;
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

import com.example.academytask1.R;
import com.example.academytask1.ui.AppDelegate;
import com.example.academytask1.ui.model.Event;
import com.example.academytask1.ui.ui.OnItemClickListener;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

public class FragmentEventList extends Fragment implements
        OnItemClickListener {

    private RecyclerView mRecyclerView;
    private RecyclerAdapterEvent mAdapter;
    private ProgressBar mProgressBar;
    private DownloadEvent downloadEvent;

    @Inject
    List<Event> mEvents;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppDelegate.getAppComponent().inject(this);
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
        mAdapter = new RecyclerAdapterEvent();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter.setListener(this);
        mRecyclerView.setAdapter(mAdapter);

        downloadEvent = new DownloadEvent();
        downloadEvent.execute();
    }


    @Override
    public void itemClick(int eventId) {

        Bundle args = new Bundle();
        args.putInt(FragmentEventDetail.EVENTID, eventId);

        FragmentManager fm = getActivity().getSupportFragmentManager();
        FragmentEventDetail eventDetail = FragmentEventDetail.newInstance(args);
        eventDetail.show(fm, "fragment_event_detail");
    }

    class DownloadEvent extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mRecyclerView.setVisibility(View.GONE);
            mProgressBar.setVisibility(View.VISIBLE);

        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            mRecyclerView.setVisibility(View.VISIBLE);
            mProgressBar.setVisibility(View.GONE);

            mAdapter.addData(mEvents);

        }
    }

    @Override
    public void onDestroy() {

        if (downloadEvent != null) {
            downloadEvent.cancel(true);
        }

        super.onDestroy();
    }
}
