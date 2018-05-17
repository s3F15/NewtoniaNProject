package com.jeff.newtonianappproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HumanAct extends AppCompatActivity {
    private Button animapagebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_human);
        animapagebtn = (Button)findViewById(R.id.humanvidbtn);

        animapagebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HumanAct.this, HumanEvolutionVideo.class));
            }
        });
    }
}

