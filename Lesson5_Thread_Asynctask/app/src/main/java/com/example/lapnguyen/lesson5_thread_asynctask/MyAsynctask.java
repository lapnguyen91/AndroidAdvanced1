package com.example.lapnguyen.lesson5_thread_asynctask;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by lapnguyen on 16/05/2017.
 */

public class MyAsynctask extends AsyncTask<Void,Integer,Void> {

    Activity contextParent;

    public MyAsynctask(Activity contextParent){
        this.contextParent=contextParent;
    }



    @Override
    protected void onPreExecute() {
        //Ham duoc chay khi ASynctask duoc goi
        super.onPreExecute();
        Toast.makeText(contextParent,"Start", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected Void doInBackground(Void... params) {
        //Chay tiep theo onPreExecute
        for(int i = 1 ; i<= 100 ;i++) {
            SystemClock.sleep(50);
        //onProgressUpdate se duoc chay khi goi ham nay
            publishProgress(i);
        }
        return null;
    }
    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        ProgressBar progressBar = (ProgressBar) contextParent.findViewById(R.id.progressBar);
        int number = values[0];
        progressBar.setProgress(number);
        TextView textView = (TextView) contextParent.findViewById(R.id.lbl_progress);
        textView.setText(number+"%");

    }
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Toast.makeText(contextParent,"Complete", Toast.LENGTH_SHORT).show();
    }


}
