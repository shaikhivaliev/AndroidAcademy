package com.example.academytask1.ui.ui.talks;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.academytask1.R;
import com.example.academytask1.ui.OnItemClickListener;
import com.example.academytask1.ui.entity.Talk;

import java.util.ArrayList;
import java.util.List;

public class TalksAdapter extends RecyclerView.Adapter<TalkHolder> {

    private List<Talk> mData = new ArrayList<>();
    private OnItemClickListener mListener;

    public void addData(List<Talk> data) {
        mData.addAll(data);
        notifyDataSetChanged();
    }

    public void setListener(OnItemClickListener listener) {
        mListener = listener;
    }

    @NonNull
    @Override
    public TalkHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View v = layoutInflater.inflate(R.layout.holder_event, viewGroup, false);
        return new TalkHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TalkHolder holder, int position) {

        Talk talk = mData.get(position);
        holder.bind(talk, mListener);

    }

    @Override
    public int getItemCount() {
        return mData != null ? mData.size() : 0;
    }
}
