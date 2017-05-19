package com.example.lapnguyen.lesson6_service_broadcastreceiver;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.os.SystemClock;


public class ProgressIntentService extends IntentService {
    public static final String ACTION_1 ="MY_ACTION_1";

    public ProgressIntentService() {
        super("ProgressIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Intent broadcastIntent = new Intent();
        broadcastIntent.setAction(ProgressIntentService.ACTION_1);
    for(int i = 0 ;i<=100 ;i++)
    {
        broadcastIntent.putExtra("percent",i);
        sendBroadcast(broadcastIntent);
        SystemClock.sleep(50);
    }
    }


}
