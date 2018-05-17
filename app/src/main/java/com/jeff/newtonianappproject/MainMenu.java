package com.jeff.newtonianappproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainMenu extends AppCompatActivity {

private Button LogOut;
private Button updatePass;
private ImageButton animal;
    private ImageButton ecosystems;
    private ImageButton gravity;
    private ImageButton humanevolution;
    private ImageButton planets;
    private ImageButton quiz;
    private ImageButton aboutus;

private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        firebaseAuth = FirebaseAuth.getInstance();


        LogOut = (Button)findViewById(R.id.logoutbtn);
        updatePass = (Button)findViewById(R.id.changepasswordbtn);
        animal = (ImageButton)findViewById(R.id.animalbtn);
        ecosystems = (ImageButton)findViewById(R.id.ecobtn);
        gravity = (ImageButton)findViewById(R.id.gravbtn);
        humanevolution = (ImageButton)findViewById(R.id.hebtn);
        planets = (ImageButton)findViewById(R.id.planetsbtn);
        quiz = (ImageButton)findViewById(R.id.quizbtn);
        aboutus = (ImageButton)findViewById(R.id.abtusbtn);

        LogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(MainMenu.this, MainLoginAct.class));
                 }
              });


        animal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainMenu.this, AnimalAct.class));
            }
        });
        ecosystems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainMenu.this, EcoSystemsAct.class));
            }
        });
        gravity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainMenu.this, GravityAct.class));
            }
        });
        humanevolution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainMenu.this, HumanAct.class));
            }
        });
        planets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainMenu.this, PlanetsAct.class));
            }
        });
        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainMenu.this, QuizPage.class));
            }
        });
        aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainMenu.this, AboutUsAct.class));
            }
        });
        updatePass.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
              startActivity(new Intent(MainMenu.this, ChangePassword.class));
          }
        });
    }
}
