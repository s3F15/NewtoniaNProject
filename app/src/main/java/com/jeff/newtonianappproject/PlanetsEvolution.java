package com.jeff.newtonianappproject;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.VideoView;

public class PlanetsEvolution extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planets_evolution);

        VideoView animalview = (VideoView) findViewById(R.id.videoPlanets);
        animalview.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.plnts));

        animalview.start();
        animalview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
    }
}