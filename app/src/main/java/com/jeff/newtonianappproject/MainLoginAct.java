package com.jeff.newtonianappproject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainLoginAct extends AppCompatActivity {

    private EditText Username;
    private EditText Password;
    private Button Login;
    private Button regbtnPage;
    private Button adminbtnpage;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);

        Username = (EditText) findViewById(R.id.Email);
        Password = (EditText) findViewById(R.id.passW);
        Login = (Button) findViewById(R.id.logbtn);
        adminbtnpage = (Button) findViewById(R.id.adminbtn);
        regbtnPage = (Button) findViewById(R.id.regbtn);

        firebaseAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);
        FirebaseUser user = firebaseAuth.getCurrentUser();


        if (user != null) {
            finish();

            startActivity(new Intent(MainLoginAct.this,MainMenu.class));
        }

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Username.getText().toString(), Password.getText().toString());
            }
        });

        adminbtnpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainLoginAct.this, MainAdminLogin.class));
            }
        });
        regbtnPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainLoginAct.this, MainSignupAct.class));
            }
        });
    }
private  void validate(String userName, String userPassword){

        progressDialog.setMessage("Be the next Sir Isaac Newton!");

        firebaseAuth.signInWithEmailAndPassword(userName, userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    progressDialog.dismiss();
                    Toast.makeText(MainLoginAct.this,"Log in Successfully!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainLoginAct.this, MainMenu.class));
                }
                else{
                    Log.d("Test",task.getResult().toString());
                    Toast.makeText(MainLoginAct.this,"Log in Failed!", Toast.LENGTH_SHORT).show();
                    counter--;
                    if (counter == 0){
                        Login.setEnabled(false);
                    }
                }
            }
        });
    }
}