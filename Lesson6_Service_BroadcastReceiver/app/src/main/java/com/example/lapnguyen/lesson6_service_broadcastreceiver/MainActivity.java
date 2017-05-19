package com.example.lapnguyen.lesson6_service_broadcastreceiver;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    //BoundService
    public ClickBoundService clickBoundService;
    public boolean isBound = false;
    public ServiceConnection connection;
    TextView lbl_status;

    private Button btnStartProgress;
    private Button btnStopProgress;
    private TextView lbl_percent;
    private ProgressBar progressBar;
    private Intent serviceIntent;

    private ResponseReceiver receiver = new ResponseReceiver();

    public class ResponseReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent){
            if(intent.getAction().equals(ProgressIntentService.ACTION_1)) {
                int value = intent.getIntExtra("percent", -1);
                new ShowProgressBarTask().execute(value);
            }
        }
        }

    class ShowProgressBarTask extends AsyncTask<Integer, Integer, Integer> {
        @Override
        protected Integer doInBackground(Integer... args) {

            return args[0];
        }

        @Override
        protected void onPostExecute(Integer result) {
            super.onPostExecute(result);

            progressBar.setProgress(result);

            lbl_percent.setText(result + " % Loaded");

            if (result == 100) {
                lbl_percent.setText("Completed");
                btnStartProgress.setEnabled(true);
            }

        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lbl_status = (TextView) findViewById(R.id.lbl_Status);
        //Bound init
        final Button btnStart = (Button) findViewById(R.id.btnStartBound);
        final Button btnPause = (Button) findViewById(R.id.btnPauseBound);
        final Button btnStop = (Button) findViewById(R.id.btnStopBound);
        final TextView lbl_StatusBound = (TextView) findViewById(R.id.lbl_StatusBound);
        //Intent init
        this.btnStartProgress = (Button) this.findViewById(R.id.btnStartProgress);
        this.btnStopProgress = (Button) this.findViewById(R.id.btnStopProgress);
        this.lbl_percent = (TextView) this.findViewById(R.id.text_percent);
        this.progressBar = (ProgressBar) this.findViewById(R.id.progressBar);


        connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
                ClickBoundService.myBinder binder = (ClickBoundService.myBinder) service;
                clickBoundService = binder.getService();
                }

        @Override
        public void onServiceDisconnected(ComponentName name) {
                isBound = false;
                }
                };
        //Set onClick for
        final Intent intent = new Intent(MainActivity.this,ClickBoundService.class);

        btnStart.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                bindService(intent, connection, Context.BIND_AUTO_CREATE);
                lbl_StatusBound.setText("Start");
                isBound=true;
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(isBound){
                    unbindService(connection);
                    lbl_StatusBound.setText("Stop");
                    isBound=false;
                }
            }
        });
        btnPause.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (isBound) {
                    clickBoundService.pause();
                    lbl_StatusBound.setText("Pause");
                } else {
                    Toast.makeText(MainActivity.this, "Service hasn't start yet.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    //

    //Unbound Service
    public void Start(View view){
        Intent myIntent = new Intent(MainActivity.this,ClickService.class);
        this.startService(myIntent);
        lbl_status.setText("Start");
    }
    public void Stop(View view){
        Intent myIntent = new Intent(MainActivity.this,ClickService.class);
        this.stopService(myIntent);
        lbl_status.setText("Stop");

    }
    //Inent Service
    @Override
    protected void onResume(){
        super.onResume();
        registerReceiver(receiver,new IntentFilter(ProgressIntentService.ACTION_1));
    }
    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(receiver);
    }

    public void startButtonClicked(View view)  {
        btnStartProgress.setEnabled(false);
        serviceIntent = new Intent(this, ProgressIntentService.class);
        startService(serviceIntent);
    }

    public void stopButtonClicked(View view) {
            serviceIntent = new Intent(this, ProgressIntentService.class);
            stopService(serviceIntent);
        Log.v("intent", "stop");
        }
    }



