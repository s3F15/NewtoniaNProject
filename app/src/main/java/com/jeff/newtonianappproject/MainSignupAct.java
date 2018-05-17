package com.jeff.newtonianappproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainSignupAct extends AppCompatActivity {

    private EditText firstName, lastName, userN, passW, rpassW, em, adr;
    private Button regBtn, returnBtn;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_signup);
        setupUIViews();

        firebaseAuth = FirebaseAuth.getInstance();

        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()){
                    //upload to firebase
                    String user_email = em.getText().toString().trim();
                    String user_password = passW.getText().toString().trim();

                    firebaseAuth.createUserWithEmailAndPassword(user_email, user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>(){
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(MainSignupAct.this, "Registered Successfully",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(MainSignupAct.this, MainLoginAct.class));
                            }
                            else {
                                Toast.makeText(MainSignupAct.this, "Registration Failed!",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            startActivity(new Intent(MainSignupAct.this, MainLoginAct.class));
            }
        });
    }
    private void setupUIViews() {
        firstName = (EditText) findViewById(R.id.fn);
        lastName = (EditText) findViewById(R.id.ln);
        userN = (EditText) findViewById(R.id.userN);
        passW = (EditText) findViewById(R.id.passWadmin);
        rpassW = (EditText) findViewById(R.id.repassW);
        em = (EditText) findViewById(R.id.email);
        adr = (EditText) findViewById(R.id.adr);
        regBtn = (Button) findViewById(R.id.submitreg);
        returnBtn = (Button) findViewById(R.id.returnLOG);
    }

    private Boolean validate() {
        Boolean result = false;

        String fname = firstName.getText().toString();
        String lname = lastName.getText().toString();
        String uname = userN.getText().toString();
        String pas = passW.getText().toString();
        String rpas = rpassW.getText().toString();
        String eml = em.getText().toString();
        String adrs = adr.getText().toString();

        if (fname.isEmpty() || lname.isEmpty() || uname.isEmpty() || pas.isEmpty() || rpas.isEmpty() || eml.isEmpty() || adrs.isEmpty()) {
            Toast.makeText(MainSignupAct.this, "Please fill up all of the information above!", Toast.LENGTH_SHORT);
        } else {
            result = true;
        }
        return result;
    }

    public void open_password(View v){

        finish();
        Intent intent = new Intent(MainSignupAct.this, ChangePassword.class);
        startActivity(intent);
    }
}

