package com.example.academytask1.ui.ui.speaker;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.academytask1.R;
import com.example.academytask1.ui.model.Speaker;
import com.example.academytask1.ui.ui.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapterSpeaker extends RecyclerView.Adapter<HolderSpeaker> {

    private List<Speaker> mData = new ArrayList<>();
    private OnItemClickListener mListener;

    public void addData(List<Speaker> data) {
        mData.addAll(data);
    }

    public void setListener(OnItemClickListener listener) {
        mListener = listener;
    }

    @NonNull
    @Override
    public HolderSpeaker onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View v = layoutInflater.inflate(R.layout.holder_speaker, viewGroup, false);
        return new HolderSpeaker(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderSpeaker holder, int position) {

        Speaker speaker = mData.get(position);
        holder.bind(speaker, mListener);

    }

    @Override
    public int getItemCount() {
        return mData != null ? mData.size() : 0;
    }


}
