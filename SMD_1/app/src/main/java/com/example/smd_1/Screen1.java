package com.example.smd_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Screen1 extends AppCompatActivity {
ImageButton Bback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.screen_1);
        init();
        Bback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Screen1.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });



    }
    public void init()
    {
        Bback=findViewById(R.id.Bback);
    }


}
