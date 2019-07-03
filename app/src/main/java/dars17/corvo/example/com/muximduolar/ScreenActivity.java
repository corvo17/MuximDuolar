package dars17.corvo.example.com.muximduolar;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class ScreenActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splas_screen);
        MyTask task = new MyTask();
        task.execute();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            public void run() {
              //  myRun();
            }

        }, 1000);

    }
    void  myRun(){
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    private class MyTask extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myRun();
            return null;
        }
    }
}