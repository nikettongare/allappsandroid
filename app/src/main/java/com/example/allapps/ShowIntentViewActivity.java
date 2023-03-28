package com.example.allapps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.Objects;

public class ShowIntentViewActivity extends AppCompatActivity {

    TextView usernameTFC, passwordTFC;

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_intent_view);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        usernameTFC = findViewById(R.id.usernameTF);
        passwordTFC = findViewById(R.id.passwordTF);


        String username = getIntent().getExtras().getString("username");
        String password = getIntent().getExtras().getString("password");
        Log.i("TAG", "onCreate: " + username + password);

        usernameTFC.setText(username);
        passwordTFC.setText(password);
    }
}