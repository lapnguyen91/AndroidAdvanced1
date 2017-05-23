package com.example.lapnguyen.lesson8_contentprovider;

import android.app.Activity;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.content.DialogInterface;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickAddName(View view){
        ContentValues values = new ContentValues();

        values.put(EmployeeProvider.NAME, ((EditText) findViewById(R.id.txtName)).getText().toString());
        values.put(EmployeeProvider.DIVISION, ((EditText) findViewById(R.id.txtDivisions)).getText().toString());

        Uri uri = getContentResolver().insert(EmployeeProvider.CONTENT_URI, values);

        Toast.makeText(getBaseContext(), uri.toString(), Toast.LENGTH_LONG).show();
    }
    public void onClickRetrieveEmployee (View view){
        String URI = "content://com.example.lapnguyen.lesson8_contentprovider.HR/employee";
        Uri employee = Uri.parse(URI);
        //Cursor c =  managedQuery(employee, null, null, null, "name");
        Cursor c = getContentResolver().query(employee, null, null, null, "_id");
        if(c.moveToFirst()){
            do{
                Toast.makeText(this, c.getString(c.getColumnIndex(EmployeeProvider._ID)) +
                        ", " + c.getString(c.getColumnIndex(EmployeeProvider.NAME)) +
                        ", " + c.getString(c.getColumnIndex(EmployeeProvider.DIVISION)), Toast.LENGTH_SHORT).show();
            }while (c.moveToNext());

        }
    }
    public void onClickRemoveFirstRow (View view){
        String URI = "content://com.example.lapnguyen.lesson8_contentprovider.HR/employee";
        Uri employee = Uri.parse(URI);

        //Xoa record dau tien trong db
        Cursor c = getContentResolver().query(employee, null, null, null, "_id");

        if(c.moveToFirst()) {
            int id = c.getInt(0);
            String[] args = {String.valueOf(id)};
            getContentResolver().delete(employee, EmployeeProvider._ID + " = ?", args);
            Toast.makeText(this, "First row deleted.", Toast.LENGTH_SHORT).show();
        }
    }
}
