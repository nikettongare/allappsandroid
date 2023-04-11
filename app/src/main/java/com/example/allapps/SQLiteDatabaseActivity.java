package com.example.allapps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.allapps.models.UserModel;

import java.util.ArrayList;
import java.util.List;

public class SQLiteDatabaseActivity extends AppCompatActivity {

    EditText nameTFC, mobileTFC;
    Button submitBtn;

    ListView listView;
    DatabaseHandler databaseHandler = new DatabaseHandler(this);


    List<UserModel> rawData;
    private void getDataAndSetArrayAdapter () {
        rawData = databaseHandler.getAllData();
        List<String> data = new ArrayList<String>();;

        rawData.forEach(user -> {
            data.add(user.getName());
        });

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                data);
        listView.setAdapter(arrayAdapter);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_database);

        nameTFC = findViewById(R.id.nameTF);
        mobileTFC = findViewById(R.id.mobileTF);

        submitBtn = findViewById(R.id.submit);

        listView = findViewById(R.id.myList);

        getDataAndSetArrayAdapter();

        submitBtn.setOnClickListener(v -> {
            String name = nameTFC.getText().toString();
            String mobile = mobileTFC.getText().toString();

            nameTFC.setText("");
            mobileTFC.setText("");

            if (name.length() < 1 || mobile.length() < 1) {
                Toast.makeText(this, "All field are required!", Toast.LENGTH_SHORT).show();
                return;
            }

            databaseHandler.addRecord(name, mobile);
            Toast.makeText(this, "Data Inserted", Toast.LENGTH_SHORT).show();
            getDataAndSetArrayAdapter();
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                databaseHandler.deleteData(rawData.get(i).getId());
                getDataAndSetArrayAdapter();
            }
        });
    }
}