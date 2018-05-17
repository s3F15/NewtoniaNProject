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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ChangePassword extends AppCompatActivity {

    public static final String TAG = "PASSWORD_MSG";
    EditText cpt, etEmail, etOldPass;
    FirebaseAuth autPass;
    ProgressDialog dialog;
    Button updatePassBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        cpt = (EditText) findViewById(R.id.newpassText);
        etEmail = (EditText) findViewById(R.id.et_email);
        etOldPass = (EditText) findViewById(R.id.et_old_pass);
        updatePassBtn = (Button) findViewById(R.id.updtPassbtn);
        autPass = FirebaseAuth.getInstance();
        dialog = new ProgressDialog(this);

        updatePassBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update(view);
            }
        });
    }

    public void update(View v) {
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        final AuthCredential credential = EmailAuthProvider
                .getCredential(etEmail.getText().toString(), etOldPass.getText().toString());

// Prompt the user to re-provide their sign-in credentials
        assert user != null;
        user.reauthenticate(credential)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            user.updatePassword(cpt.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(getBaseContext(),
                                                "Password Updated Successfully",
                                                Toast.LENGTH_LONG)
                                                .show();
                                        startActivity(new Intent(
                                                ChangePassword.this, MainMenu.class));
                                        Log.d(TAG, "Password updated");
                                    } else {
                                        Toast.makeText(getBaseContext(),
                                                "Error Password not Updated",
                                                Toast.LENGTH_LONG)
                                                .show();
                                        Log.d(TAG, "Error password not updated");
                                    }
                                }
                            });
                        } else {
                            Log.d(TAG, "Something went wrong!");

                            assert task.getException() != null;
                            Toast.makeText(getBaseContext(),
                                    task.getException().getMessage(),
                                    Toast.LENGTH_LONG)
                                    .show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d(TAG, e.getMessage());
            }
        });
    }
}


