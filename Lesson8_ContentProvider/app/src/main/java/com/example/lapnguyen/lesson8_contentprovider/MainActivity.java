package com.example.lapnguyen.lesson8_contentprovider;

import android.app.Activity;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.CursorLoader;
import android.content.DialogInterface;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lapnguyen.lesson8_contentprovider.Adapter.EmployeeAdapter;

public class MainActivity extends Activity {
    DatabaseHelper db;
    private Button btnRetrieveList;
    final Context context = this;
    private RecyclerView rvEmployee;
    RecyclerView.LayoutManager employeeLayoutManager;


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

    public void onClickRetrieveEmployee (View view) {
        String URI = "content://com.example.lapnguyen.lesson8_contentprovider.HR/employee";
        Uri employee = Uri.parse(URI);
        Cursor c = getContentResolver().query(employee, null, null, null, "_id");
        rvEmployee = (RecyclerView) findViewById(R.id.rv_employee);
        btnRetrieveList = (Button) findViewById(R.id.btnRetrieve);
        btnRetrieveList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                final Dialog dialog = new  Dialog(context);
                final View convertView = LayoutInflater.from(context).inflate(R.layout.employee_list_dialog, null);
                dialog.setTitle("Employee list:");
                dialog.setContentView(convertView);
                db = new DatabaseHelper(getApplicationContext());
                rvEmployee = (RecyclerView)convertView.findViewById(R.id.rv_employee);
                EmployeeAdapter employeeAdapter = new EmployeeAdapter(getApplicationContext());
                employeeLayoutManager = new LinearLayoutManager(getApplicationContext());
                rvEmployee.setAdapter(employeeAdapter);
                rvEmployee.setLayoutManager(employeeLayoutManager);
                int  i = db.getCount()+1;

                dialog.show();

                Button dialogButton = (Button) convertView.findViewById(R.id.btnCloseDialog);
                // if button is clicked, close the custom dialog
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
            }
        });
    }
    public void onClickRemoveFirstRow (View view){
        String URI = "content://com.example.lapnguyen.lesson8_contentprovider.HR/employee";
        Uri employee = Uri.parse(URI);
        Cursor c = getContentResolver().query(employee, null, null, null, "_id");
        if(c.moveToFirst()) {
            int id = c.getInt(0);
            String[] args = {String.valueOf(id)};
            getContentResolver().delete(employee, EmployeeProvider._ID + " = ?", args);
            Toast.makeText(this, "First row deleted.", Toast.LENGTH_SHORT).show();
        }
    }
}
