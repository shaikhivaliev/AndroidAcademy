package com.example.academytask1.ui.ui.event;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.academytask1.R;
import com.example.academytask1.ui.model.Event;
import com.example.academytask1.ui.ui.OnItemClickListener;

public class HolderEvent extends RecyclerView.ViewHolder {

    private TextView mTime;
    private TextView mName;
    private TextView mPlace;
    private TextView mTag;
    private TextView mSpeaker;
    private TextView mSpeakerDescription;


    public HolderEvent(@NonNull View itemView) {
        super(itemView);
        mTime = itemView.findViewById(R.id.tv_event_time);
        mName = itemView.findViewById(R.id.tv_event_name);
        mPlace = itemView.findViewById(R.id.tv_event_place);
        mTag = itemView.findViewById(R.id.tag_event);
        mSpeaker = itemView.findViewById(R.id.tv_event_speaker);
        mSpeakerDescription = itemView.findViewById(R.id.tv_event_speaker_description);

    }

    public void bind(final Event event, final OnItemClickListener listener) {

        mTime.setText(event.getTime());
        mName.setText(event.getName());
        mPlace.setText(event.getPlace());
        mTag.setText(event.getTag());
        mSpeaker.setText(event.getSpeaker().getName());
        mSpeakerDescription.setText(event.getSpeaker().getFullDescription());


        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.itemClick(event.getId());
            }
        });

    }
}
