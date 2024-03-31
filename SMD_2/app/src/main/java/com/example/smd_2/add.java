package com.example.smd_2;


import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class add extends AppCompatActivity {
  TextInputEditText etname,etlocation,etnumber,etdesc,etrating;
    Button btnadd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.add);

        init();



        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String etn = etname.getText().toString();
                String etl = etlocation.getText().toString();
                String etnum = etnumber.getText().toString();
                String etd = etdesc.getText().toString();
                String etr = etrating.getText().toString();


                Intent intent = new Intent(add.this,MainActivity.class);
                intent.putExtra("etn",etn);
                intent.putExtra("etl", etl);
                intent.putExtra("etnum", etnum);
                intent.putExtra("etd", etd);
                intent.putExtra("etr", etr);
                setResult(RESULT_OK, intent);
                finish();

            }
        });

    }

    private void init()
    {
        etname=findViewById(R.id.etname);
        etlocation=findViewById(R.id.etlocation);
        etnumber=findViewById(R.id.etnumber);
        etdesc=findViewById(R.id.etdesc);
        etrating=findViewById(R.id.etrating);
        btnadd = findViewById(R.id.btnadd);
    }
}
