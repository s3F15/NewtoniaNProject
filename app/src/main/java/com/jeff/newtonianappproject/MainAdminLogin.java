package com.jeff.newtonianappproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainAdminLogin extends AppCompatActivity {

    private EditText adminU;
    private EditText adminP;
    private Button adminR;
    private Button adminlog;
    private TextView attempts;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_admin_login);

        adminU = (EditText)findViewById(R.id.useradmin);
        adminP = (EditText)findViewById(R.id.passWadmin);
        attempts = (TextView)findViewById(R.id.noatmp);
        adminlog = (Button)findViewById(R.id.logbtnadmin);
        adminR = (Button)findViewById(R.id.adminreturnbtn);

        attempts.setText("No of attempts remaining: 5");

        adminlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(adminU.getText().toString(), adminP.getText().toString());
            }
        });

        adminR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainAdminLogin.this, MainLoginAct.class));
            }
        });
    }
    private void validate(String userName, String userPassword){
        if((userName.equals("Josef")) && (userPassword.equals("1510215"))){
            Toast.makeText(MainAdminLogin.this, "WELCOME ADMIN JOSEF!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainAdminLogin.this, MainAdminPageAct.class);
            startActivity(intent);
        }else{
            counter--;
            attempts.setText("No of attempts remaining: " + String.valueOf(counter));

            if(counter == 0){
                Toast.makeText(MainAdminLogin.this, "Too Many Attempts", Toast.LENGTH_SHORT).show();
                adminlog.setEnabled(false);
                startActivity(new Intent(MainAdminLogin.this, MainLoginAct.class));
            }
        }
    }
}