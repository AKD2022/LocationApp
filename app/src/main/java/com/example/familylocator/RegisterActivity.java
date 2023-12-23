package com.example.familylocator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    EditText register_email;
    FirebaseAuth auth;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        register_email = (EditText) findViewById(R.id.editTextEmailRegister);
        auth = FirebaseAuth.getInstance();
        dialog = new ProgressDialog(this);
    }

    public void gotToPasswordActivity (View v) {
        Intent myIntent = new Intent(RegisterActivity.this, PasswordActivity.class);
        myIntent.putExtra("email", register_email.getText().toString());
        startActivity(myIntent);
    }
}