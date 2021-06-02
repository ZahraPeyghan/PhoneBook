package com.example.pohonebook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SubmitActivity extends AppCompatActivity {
 FirebaseAuth auth;
 EditText namebox,phonebox,emailebox,passwordbox;
 Button loginbtn,registerbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);
        auth=FirebaseAuth.getInstance();
        namebox=findViewById(R.id.namebox);
        phonebox=findViewById(R.id.mobilebox);
        emailebox=findViewById(R.id.emailbox);
        passwordbox=findViewById(R.id.passwordbox);
        loginbtn=findViewById(R.id.loginbtn);
        registerbtn=findViewById(R.id.registerbtn);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SubmitActivity.this,LoginActivity.class));
            }
        });
        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name,mobile,email,pass;
                name=namebox.getText().toString();
                mobile=phonebox.getText().toString();
                email=emailebox.getText().toString();
                pass=passwordbox.getText().toString();
                auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(SubmitActivity.this,"Your Account is Creat!",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(SubmitActivity.this,LoginActivity.class));
                        }else {
                            Toast.makeText(SubmitActivity.this,task.getException().getLocalizedMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}
