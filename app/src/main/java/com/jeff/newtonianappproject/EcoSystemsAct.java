package com.jeff.newtonianappproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EcoSystemsAct extends AppCompatActivity {
    private Button ecopage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_eco_systems);
        ecopage = (Button)findViewById(R.id.ecosystemsvid);

        ecopage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EcoSystemsAct.this, EcosystemsVideo.class));
            }
        });
    }
}

