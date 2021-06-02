package com.example.pohonebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

public class SubmitPhoneActivity extends AppCompatActivity {
    Button submitbtn;
    EditText namebox,phonebox,mobilebox;
    FirebaseFirestore Database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_phone);
        submitbtn=findViewById(R.id.submitbtn);
        namebox=findViewById(R.id.namebox);
        phonebox=findViewById(R.id.phonebox);
        mobilebox=findViewById(R.id.mobilebox);
        Database=FirebaseFirestore.getInstance();
        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name,phone,mobile;
                name=namebox.getText().toString();
                phone=phonebox.getText().toString();
                mobile=mobilebox.getText().toString();
                User user=new User();
                user.setName(name);
                user.setPhone(phone);
                user.setMobile(mobile);
                Database.collection("Users").document().set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(SubmitPhoneActivity.this,"Your User was added!",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SubmitPhoneActivity.this,LoginActivity.class));
                    }
                });
            }
        });
    }
}
