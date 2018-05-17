package com.jeff.newtonianappproject;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.VideoView;

public class AnimalVideo extends AppCompatActivity { Button play1;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_animal_video);

            VideoView animalview = (VideoView) findViewById(R.id.videoAnimal);
            animalview.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.ak));

            animalview.start();
            animalview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.setLooping(true);
                }
            });
        }
    }


