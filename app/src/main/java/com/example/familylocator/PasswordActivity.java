package com.example.familylocator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PasswordActivity extends AppCompatActivity {
    String email;
    EditText register_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        register_password = (EditText) findViewById(R.id.editTextPasswordRegister);

        Intent myIntent = getIntent();
        if(myIntent!= null) {
            email = myIntent.getStringExtra("email");
        }
    }

    public void goToNamePicActivity(View v) {
        if (register_password.getText().toString().length() > 6) {
            Intent myIntent = new Intent(PasswordActivity.this, NameActivity.class);
            myIntent.putExtra("email", email);
            myIntent.putExtra("password", register_password.getText().toString());
            startActivity(myIntent);
        } else {
            Toast.makeText(this, "Password length should be more than 6 characters", Toast.LENGTH_SHORT).show();
        }
    }
}