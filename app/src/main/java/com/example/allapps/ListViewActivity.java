package com.example.allapps;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class ListViewActivity extends AppCompatActivity {

    VideoView ved;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        ved = findViewById(R.id.videoView);

        String path = "android.resource://" + getPackageName() + "/" + R.raw.file;
        ved.setVideoURI(Uri.parse(path));

        MediaController med = new MediaController(this);
        ved.setMediaController(med);

        med.setAnchorView(ved);
        ved.start();
    }
}