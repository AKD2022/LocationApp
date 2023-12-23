package com.example.familylocator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import de.hdodenhof.circleimageview.CircleImageView;

public class NameActivity extends AppCompatActivity {

    String email, password;
    EditText editName;
    CircleImageView circleImageView;

    Uri resultUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        editName = (EditText) findViewById(R.id.editName);
        circleImageView = (CircleImageView) findViewById(R.id.circleImageUserLogo);

        Intent myIntent = getIntent();
        if (myIntent != null) {
            email = myIntent.getStringExtra("email");
            password = myIntent.getStringExtra("password");
        }
    }

    public void generateCode(View v) {
        Date myDate = new Date();
        SimpleDateFormat format1 = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss a", Locale.getDefault());
        String date = format1.format(myDate);
        Random r = new Random();

        int n = 100000 + r.nextInt(900000);
        String code = String.valueOf(n);

        if (resultUri != null) {
            Intent myIntent = new Intent(NameActivity.this, InviteCode.class);
            myIntent.putExtra("name", editName.getText().toString());
            myIntent.putExtra("email", email);
            myIntent.putExtra("password", password);
            myIntent.putExtra("date", date);
            myIntent.putExtra("isSharing", "false");
            myIntent.putExtra("code", code);
            myIntent.putExtra("imageUri", resultUri);
        } else {
            Toast.makeText(this, "Please Choose an image", Toast.LENGTH_SHORT).show();
        }
    }
}