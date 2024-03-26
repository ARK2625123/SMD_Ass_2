package com.example.smd_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class Screen1 extends AppCompatActivity {
ImageButton Bback;
Button call,message;
Fragment fragCall,fragMessage;
FragmentManager manager;
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
        manager=getSupportFragmentManager();

        manager.beginTransaction()
                .replace(R.id.frag_container, fragCall)
                .commit();



        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frag_container, fragCall)
                        .commit();
            }
        });

        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frag_container, fragMessage)
                        .commit();
            }
        });



    }
    public void init()
    {

        Bback=findViewById(R.id.Bback);
        call=findViewById(R.id.call);
        message=findViewById(R.id.message);
        fragCall=new fragcall();
        fragMessage=new fragmessage();
    }


}
