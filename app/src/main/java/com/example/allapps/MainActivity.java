package com.example.allapps;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button dialogBtn, gotoListviewBtn;

    Dialog loginModelRef;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        DatabaseHandler databaseHandler = new DatabaseHandler(this);
        List<String> data = databaseHandler.getAllData();

        // Date date = new Date();
        // databaseHandler.addRecord(155.22, 58.10, 127.21,date.toString());

        ListView listView = findViewById(R.id.myListView);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                data);

        listView.setAdapter(arrayAdapter);

        gotoListviewBtn = findViewById(R.id.goto_listview);
        gotoListviewBtn.setOnClickListener(v -> {
            Intent myIntent = new Intent(MainActivity.this, ListViewActivity.class);
            MainActivity.this.startActivity(myIntent);
        });

        dialogBtn = findViewById(R.id.open_dialog);
        dialogBtn.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Show Dialog", Toast.LENGTH_SHORT).show();

            loginModelRef = new Dialog(MainActivity.this);
            loginModelRef.setContentView(R.layout.login_model);

            EditText usernameTFRef, passwordTFRef;

            usernameTFRef = loginModelRef.findViewById(R.id.usernameTF);
            passwordTFRef = loginModelRef.findViewById(R.id.passwordTF);

            loginModelRef.findViewById(R.id.submit).setOnClickListener(v1 -> {
                String usernameText = usernameTFRef.getText().toString().trim();
                String passwordText = passwordTFRef.getText().toString().trim();

                Toast.makeText(MainActivity.this, "Username is " + usernameText +
                        " and password is " + passwordText, Toast.LENGTH_SHORT).show();
                loginModelRef.cancel();
            });
            loginModelRef.show();
        });
    }
}