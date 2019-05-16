package com.example.academytask1.ui.ui.events;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.academytask1.R;
import com.example.academytask1.ui.OnItemClickListener;
import com.example.academytask1.ui.entity.Event;

public class EventHolder extends RecyclerView.ViewHolder {

    private TextView mTime;
    private TextView mName;
    private TextView mRoom;
    private TextView mTrack;
    private TextView mSpeaker;


    public EventHolder(@NonNull View itemView) {
        super(itemView);
        mTime = itemView.findViewById(R.id.tv_event_time);
        mName = itemView.findViewById(R.id.tv_event_name);
        mRoom = itemView.findViewById(R.id.tv_event_place);
        mTrack = itemView.findViewById(R.id.tag_event);
        mSpeaker = itemView.findViewById(R.id.tv_event_speaker);

    }

    public void bind(final Event event, final OnItemClickListener listener) {

        mTime.setText(event.getTime());
        mName.setText(event.getTitle());
        mRoom.setText(String.valueOf(event.getRoom()));
        mTrack.setText(event.getTrack());
        mSpeaker.setText(event.getSpeaker());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.itemClick(String.valueOf(event.getEventId()));
            }
        });
    }
}
