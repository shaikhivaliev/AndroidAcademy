package com.example.academytask1.ui.ui.speakers;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.academytask1.R;
import com.example.academytask1.ui.OnItemClickListener;
import com.example.academytask1.ui.entity.Speaker;
import com.squareup.picasso.Picasso;

public class SpeakerHolder extends RecyclerView.ViewHolder {

    private TextView mFirstName;
    private TextView mSecondName;
    private TextView mJobTitle;
    private TextView mLocation;
    private ImageView mSpeakerPhoto;


    public SpeakerHolder(@NonNull View itemView) {
        super(itemView);

        mFirstName = itemView.findViewById(R.id.tv_speaker_first_name);
        mSecondName = itemView.findViewById(R.id.tv_speaker_second_name);
        mJobTitle = itemView.findViewById(R.id.tv_speaker_job_title);
        mLocation = itemView.findViewById(R.id.tv_speaker_location);
        mSpeakerPhoto = itemView.findViewById(R.id.iv_speaker_photo);
    }


    public void bind(final Speaker speaker, final OnItemClickListener listener) {

        Log.d("PHOTO", "bind: " + speaker.getPhotoUrl() );
        Picasso.get()
                .load(Uri.parse(speaker.getPhotoUrl()))
                .error(R.drawable.ic_launcher_background)
                .into(mSpeakerPhoto);

        mFirstName.setText(speaker.getFirstName());
        mSecondName.setText(speaker.getLastName());
        mJobTitle.setText(speaker.getJobTitle());
        mLocation.setText(speaker.getLocation());


        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.itemClick(speaker.getSpeakerId());
            }
        });
    }

}
