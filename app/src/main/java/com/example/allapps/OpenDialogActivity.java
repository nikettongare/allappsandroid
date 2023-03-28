package com.example.allapps;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class OpenDialogActivity extends AppCompatActivity {
    Button dialogBtn;
    Dialog loginModelRef;

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_dialog);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dialogBtn = findViewById(R.id.open_dialog);
        dialogBtn.setOnClickListener(v -> {
            Toast.makeText(OpenDialogActivity.this, "Show Dialog", Toast.LENGTH_SHORT).show();

            loginModelRef = new Dialog(OpenDialogActivity.this);
            loginModelRef.setContentView(R.layout.login_model);

            EditText usernameTFRef, passwordTFRef;

            usernameTFRef = loginModelRef.findViewById(R.id.usernameTF);
            passwordTFRef = loginModelRef.findViewById(R.id.passwordTF);

            loginModelRef.findViewById(R.id.submit).setOnClickListener(v1 -> {
                String usernameText = usernameTFRef.getText().toString().trim();
                String passwordText = passwordTFRef.getText().toString().trim();

                Toast.makeText(OpenDialogActivity.this, "Username is " + usernameText +
                        " and password is " + passwordText, Toast.LENGTH_SHORT).show();
                loginModelRef.cancel();
            });
            loginModelRef.show();
        });
    }
}