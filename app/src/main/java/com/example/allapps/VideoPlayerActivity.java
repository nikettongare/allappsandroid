package com.example.allapps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;
import android.net.Uri;

public class VideoPlayerActivity extends AppCompatActivity {
    VideoView ved;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        ved = findViewById(R.id.videoView);

        String path = "android.resource://" + getPackageName() + "/" + R.raw.file;
        ved.setVideoURI(Uri.parse(path));

        MediaController med = new MediaController(this);
        ved.setMediaController(med);

        med.setAnchorView(ved);
        ved.start();
    }
}