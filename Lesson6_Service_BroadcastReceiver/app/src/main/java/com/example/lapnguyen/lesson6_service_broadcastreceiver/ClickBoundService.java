package com.example.lapnguyen.lesson6_service_broadcastreceiver;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.TextView;
import android.content.Context;

public class ClickBoundService extends Service {
    private mPlayer player ;
    private IBinder binder;



    @Override
    public void onCreate() {
        Log.d("ServiceDemo", "Đã gọi onCreate()");
        player = new mPlayer(this);
        binder = new myBinder();
        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d("ServiceDemo", "Đã gọi onBind()");
        player.play();
    return binder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d("ServiceDemo", "Đã gọi onUnbind()");
        player.stop();
        return super.onUnbind(intent);
    }

    public void pause(){
        player.pause();
    }

    public class myBinder extends Binder{
        public ClickBoundService getService(){
                return ClickBoundService.this;
        }
    }

    private class mPlayer{

        public mPlayer(ClickBoundService clickBoundService) {}
        public void play(){}
        public void pause(){}
        public void stop(){}
    }

}
