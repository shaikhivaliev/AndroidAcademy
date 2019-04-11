package com.example.academytask1.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.academytask1.R;

public class SpeakerActivity extends AppCompatActivity {

    private View mReport;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_speaker);

        mReport = findViewById(R.id.view_report);
        mReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SpeakerActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

}
