package com.example.karin.threaduses;

import android.app.Activity;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class AsyncTaskActivity extends Activity {

    Button create;
    Button start;
    Button cancel;
    CounterOperation counterOperation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);
        RelativeLayout rl = findViewById(R.id.relative);
        rl.setBackgroundColor(Color.BLUE);

        create = findViewById(R.id.createButton);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterOperation = new CounterOperation();
            }
        });

        start = findViewById(R.id.startButton);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterOperation.execute();
            }
        });

        cancel = findViewById(R.id.cancelButton);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterOperation.cancel(true);
            }
        });

    }

    private class CounterOperation extends AsyncTask<Void, Integer, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            for (int i = 1; i <= 10; i++) {
                try {
                    SystemClock.sleep(500);
                    publishProgress(i); // Invokes onProgressUpdate()
                } catch (Exception e) {
                }
                if (isCancelled()) break;
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            TextView txt = findViewById(R.id.textView1);
            txt.setText("Done!");
        }

        @Override
        protected void onPreExecute() {
        }


        @Override
        protected void onProgressUpdate(Integer... values) {
            TextView txt = findViewById(R.id.textView1);
            txt.setText(Integer.toString(values[0].intValue()));

        }


    }
}
