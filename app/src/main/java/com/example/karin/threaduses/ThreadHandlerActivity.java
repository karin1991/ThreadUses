package com.example.karin.threaduses;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import android.os.Handler;

public class ThreadHandlerActivity extends Activity  {


    Handler handlerCalled;

    TextView Txt;

    Button create;
    Button start;
    Button cancel;


    Handler handler;
    Runnable runnable;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);
        RelativeLayout rl = findViewById(R.id.relative);
        rl.setBackgroundColor(Color.RED);
        Txt = findViewById(R.id.textView1);



        create = findViewById(R.id.createButton);
        create.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          handlerCalled = new Handler();
                                          handler = new Handler();

                                              }
                                          });



        start = findViewById(R.id.startButton);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                runnable = new Runnable() {
                    int counter = 0;
                    public void run() {


                        if (counter++ < 11)
                            if(counter == 11)
                            {
                                Txt.setText("Done!");
                            }
                            else {
                                Txt.setText(Integer.toString(counter));
                                handler.postDelayed(this, 500);
                            }



                    }
                };


                handler.post(runnable);
                Txt.setText("Done!");




            }
        });



        cancel = findViewById(R.id.cancelButton);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                handler.removeCallbacks(runnable);

            }
        });


    }


}


