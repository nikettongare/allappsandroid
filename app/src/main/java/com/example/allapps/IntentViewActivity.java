package com.example.allapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class IntentViewActivity extends AppCompatActivity {

    EditText usernameTFC, passwordTFC;
    Button submitFC;

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_view);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        usernameTFC = findViewById(R.id.usernameTF);
        passwordTFC = findViewById(R.id.passwordTF);
        submitFC = findViewById(R.id.submitF);

        submitFC.setOnClickListener(v -> {
            passwordTFC.getText();
            Intent intent = new Intent(IntentViewActivity.this, ShowIntentViewActivity.class);
            intent.putExtra("username", usernameTFC.getText().toString());
            intent.putExtra("password",passwordTFC.getText().toString());
            startActivity(intent);
        });
    }
}