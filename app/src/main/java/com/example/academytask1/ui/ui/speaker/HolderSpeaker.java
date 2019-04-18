package com.example.academytask1.ui.ui.speaker;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.academytask1.R;
import com.example.academytask1.ui.model.Speaker;
import com.example.academytask1.ui.ui.OnItemClickListener;

public class HolderSpeaker extends RecyclerView.ViewHolder {

    private TextView mName;
    private TextView mDescription;
    private TextView mOrigin;


    public HolderSpeaker(@NonNull View itemView) {
        super(itemView);
        mName = itemView.findViewById(R.id.tv_speaker_name);
        mDescription = itemView.findViewById(R.id.tv_speaker_description);
        mOrigin = itemView.findViewById(R.id.tv_speaker_origin);
    }


    public void bind(final Speaker speaker, final OnItemClickListener listener) {

        mName.setText(speaker.getName());
        mDescription.setText(speaker.getShortDescription());
        mOrigin.setText(speaker.getOrigin());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.itemClick(speaker.getId());
            }
        });


    }


}
