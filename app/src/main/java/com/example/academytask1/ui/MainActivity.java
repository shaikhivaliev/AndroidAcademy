package com.example.academytask1.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.academytask1.R;

public class MainActivity extends AppCompatActivity {


    private TextView mSpeaker;
    private TextView mTag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        mTag = findViewById(R.id.tv_report_tag);
        mTag.setText(getResources().getString(R.string.android));

        mSpeaker = findViewById(R.id.tv_report_speaker);
        mSpeaker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, SpeakerActivity.class);
                startActivity(intent);
            }
        });
    }
}
