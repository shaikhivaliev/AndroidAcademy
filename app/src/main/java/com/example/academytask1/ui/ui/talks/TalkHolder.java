package com.example.academytask1.ui.ui.talks;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.academytask1.R;
import com.example.academytask1.ui.OnItemClickListener;
import com.example.academytask1.ui.entity.Talk;

public class TalkHolder extends RecyclerView.ViewHolder {

    private TextView mTime;
    private TextView mName;
    private TextView mRoom;
    private TextView mTrack;
    private TextView mSpeaker;


    public TalkHolder(@NonNull View itemView) {
        super(itemView);
        mTime = itemView.findViewById(R.id.tv_event_time);
        mName = itemView.findViewById(R.id.tv_event_name);
        mRoom = itemView.findViewById(R.id.tv_event_place);
        mTrack = itemView.findViewById(R.id.tag_event);
        mSpeaker = itemView.findViewById(R.id.tv_event_speaker);

    }

    public void bind(final Talk talk, final OnItemClickListener listener) {

        mTime.setText(talk.getTime());
        mName.setText(talk.getTitle());
        mRoom.setText(String.valueOf(talk.getRoom()));
        mTrack.setText(talk.getTrack());
        mSpeaker.setText(talk.getSpeaker());

        itemView.setOnClickListener(v -> listener.itemClick(talk.getTitle()));
    }
}
