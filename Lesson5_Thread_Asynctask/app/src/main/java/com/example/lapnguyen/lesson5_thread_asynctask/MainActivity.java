package com.example.lapnguyen.lesson5_thread_asynctask;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;

import java.util.concurrent.atomic.AtomicBoolean;


public class MainActivity extends Activity implements View.OnClickListener {
    ProgressBar bar;
    Handler handler;
    AtomicBoolean isRunning = new AtomicBoolean(false);
    Button btnStartThread;
    Button btnStartAsynctask;
    TextView lbl_progress;
    MyAsynctask myAsynctask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bar = (ProgressBar) findViewById(R.id.progressBar);
        btnStartAsynctask = (Button) findViewById(R.id.btnStartAsynctask);
        btnStartThread= (Button) findViewById(R.id.btnStartThread);
        btnStartAsynctask.setOnClickListener(this);
        btnStartThread.setOnClickListener(this);

        handler = new Handler(){
            public void handleMessage(Message msg){

                super.handleMessage(msg);
                bar.setProgress(msg.arg1);
                lbl_progress.setText(msg.arg1 + "%");
            }
        };
        lbl_progress=(TextView) findViewById(R.id.lbl_progress);
    }
    public void doStart(){
        bar.setProgress(0);
        isRunning.set(false);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<=100 && isRunning.get();i++){
                    SystemClock.sleep(50);
                    Message msg = handler.obtainMessage();
                    msg.arg1=i;
                    handler.sendMessage(msg);
                }
            }
        });
        isRunning.set(true);
        t.start();
    }

    @Override
    public void onClick(View v){
        switch (v.getId())
        {

            case R.id.btnStartThread:
                doStart();
                break;
            case R.id.btnStartAsynctask:
                myAsynctask = new MyAsynctask(MainActivity.this);
                myAsynctask.execute();


        }
    }

}
