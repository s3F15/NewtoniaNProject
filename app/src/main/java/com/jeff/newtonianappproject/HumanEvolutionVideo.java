package com.jeff.newtonianappproject;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.VideoView;

public class HumanEvolutionVideo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_human_evolution_video);

        VideoView animalview = (VideoView) findViewById(R.id.videoHuman);
        animalview.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.hetn));

        animalview.start();
        animalview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
    }
}