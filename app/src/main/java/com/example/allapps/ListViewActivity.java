package com.example.allapps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class ListViewActivity extends AppCompatActivity {
    ListView listView;
    AutoCompleteTextView autoCompleteTextView;
    Spinner spinner;

    String showList[] = {"india", "america", "japan", "china", "russia",};
    String search[] = {"sachin", "virat", "dhoni", "kartik", "bumra", "jadeja"};
    String dropdown[] = {"1", "2", "3", "4", "5"};

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listView = findViewById(R.id.myListView);
        autoCompleteTextView = findViewById(R.id.acTF);
        spinner = findViewById(R.id.spinner);

        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1,showList
        );

        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1,search
        );

        ArrayAdapter<String> arrayAdapter3 = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1,dropdown
        );

        listView.setAdapter(arrayAdapter1);
        autoCompleteTextView.setAdapter(arrayAdapter2);
        spinner.setAdapter(arrayAdapter3);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListViewActivity.this, "" + spinner.getSelectedItem().toString().trim(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListViewActivity.this, "" + autoCompleteTextView.getText(), Toast.LENGTH_SHORT).show();

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListViewActivity.this, "" + showList[i], Toast.LENGTH_SHORT).show();

            }
        });
//        DatabaseHandler databaseHandler = new DatabaseHandler(this);
//        List<String> data = databaseHandler.getAllData();

        // Date date = new Date();
        // databaseHandler.addRecord(155.22, 58.10, 127.21,date.toString());

//        ListView listView = findViewById(R.id.myListView);
//
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
//                this,
//                android.R.layout.simple_list_item_1,
//                data);
//
//        listView.setAdapter(arrayAdapter);


    }
}