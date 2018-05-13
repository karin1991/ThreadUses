package com.example.karin.threaduses;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button asyncButton;
    Button handlerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        asyncButton = findViewById(R.id.asyncTask);
        asyncButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent();
                i.setClassName("com.example.karin.threaduses",
                        "com.example.karin.threaduses.AsyncTaskActivity");
                startActivity(i);
            }
        });

        handlerButton = findViewById(R.id.handler);
        handlerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent();
                i.setClassName("com.example.karin.threaduses",
                        "com.example.karin.threaduses.ThreadHandlerActivity");
                startActivity(i);
            }
        });
    }
}
