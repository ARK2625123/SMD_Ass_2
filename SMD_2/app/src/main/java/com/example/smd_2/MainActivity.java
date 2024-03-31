package com.example.smd_2;



import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvrest;
    restadapter meraAdapter;
    ArrayList<rest> list;
    FloatingActionButton fabadd;

    EditText etsearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        init();

        rvrest.setHasFixedSize(true);
        meraAdapter = new restadapter(list);

        rvrest.setLayoutManager(new LinearLayoutManager(this));

        rvrest.setAdapter(meraAdapter);

        fabadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent=new Intent(MainActivity.this, add.class);
                startActivityForResult(intent, 1);
            }
        });

        etsearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                meraAdapter.filter(s.toString()); // Filter adapter based on search query
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            // Receive data from Page 2
            String etn = data.getStringExtra("etn");
            String etl = data.getStringExtra("etl");
            String etnum = data.getStringExtra("etnum");
            String etd= data.getStringExtra("etd");
            String etr = data.getStringExtra("etr");


            // Create a new item with the received values and add it to the dataset
            rest newItem = new rest(etr, etn,etl,etnum,etd);
            list.add(newItem);

            meraAdapter.notifyDataSetChanged();
        }
    }

    private void init()
    {
        list = new ArrayList<>();
        list.add(new rest("4.5","Ghr ka khana","ghr","aur khao","041"));


        rvrest = findViewById(R.id.rvrest);
        etsearch = findViewById(R.id.etsearch);
        fabadd = findViewById(R.id.fabadd);






    }
}