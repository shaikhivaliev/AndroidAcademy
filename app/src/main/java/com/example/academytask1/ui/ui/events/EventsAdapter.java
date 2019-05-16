package com.example.academytask1.ui.ui.events;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.academytask1.R;
import com.example.academytask1.ui.OnItemClickListener;
import com.example.academytask1.ui.entity.Event;

import java.util.ArrayList;
import java.util.List;

public class EventsAdapter extends RecyclerView.Adapter<EventHolder> {

    private List<Event> mData = new ArrayList<>();
    private OnItemClickListener mListener;

    public void addData(List<Event> data) {
        mData.addAll(data);
    }

    public void setListener(OnItemClickListener listener) {
        mListener = listener;
    }

    @NonNull
    @Override
    public EventHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View v = layoutInflater.inflate(R.layout.holder_event, viewGroup, false);
        return new EventHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull EventHolder holder, int position) {

        Event event = mData.get(position);
        holder.bind(event, mListener);

    }

    @Override
    public int getItemCount() {
        return mData != null ? mData.size() : 0;
    }
}
