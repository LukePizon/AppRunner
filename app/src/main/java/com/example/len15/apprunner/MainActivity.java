package com.example.len15.apprunner;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

     TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output = findViewById(R.id.textView);
    }
    public void runClickHandler(View view){
        //output.append("Button clicked\n");
        MyAsyncTask task = new MyAsyncTask();
        task.execute("String1" , "String2", "String3");

    }
    public void clearClickHandler(View view) {
        output.setText("");
    }

    @SuppressLint("StaticFieldLeak")
    private class MyAsyncTask extends AsyncTask<String, String, Void> {
        @Override
        protected  Void doInBackground(String... strings){
            for (String string: strings){
                publishProgress(string);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values){
            super.onProgressUpdate(values);
            output.append(values[0] + "\n");
        }
    }
}
