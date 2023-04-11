package com.example.allapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button gotoIntentViewBtn, gotoOpenDialogBtn, gotoListviewBtn, gotoWebviewBtn, gotoSqlActivityBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gotoListviewBtn = findViewById(R.id.goto_listview);
        gotoListviewBtn.setOnClickListener(v -> {
            Intent myIntent = new Intent(MainActivity.this, ListViewActivity.class);
           startActivity(myIntent);
        });

        gotoOpenDialogBtn = findViewById(R.id.goto_open_dialog);
        gotoOpenDialogBtn.setOnClickListener(v -> {
            Intent myIntent = new Intent(MainActivity.this, OpenDialogActivity.class);
            startActivity(myIntent);
        });

        gotoIntentViewBtn = findViewById(R.id.goto_intent_view);
        gotoIntentViewBtn.setOnClickListener(v -> {
            Intent myIntent = new Intent(MainActivity.this, IntentViewActivity.class);
            startActivity(myIntent);
        });

        gotoWebviewBtn = findViewById(R.id.goto_webview);
        gotoWebviewBtn.setOnClickListener(v -> {
            Intent myIntent = new Intent(MainActivity.this, WebViewActivity.class);
            startActivity(myIntent);
        });

        gotoSqlActivityBtn = findViewById(R.id.goto_sql_activity);
        gotoSqlActivityBtn.setOnClickListener(v -> {
            Intent myIntent = new Intent(MainActivity.this, SQLiteDatabaseActivity.class);
            startActivity(myIntent);
        });
    }
}