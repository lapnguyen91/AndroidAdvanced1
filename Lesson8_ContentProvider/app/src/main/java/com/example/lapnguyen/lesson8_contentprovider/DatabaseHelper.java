package com.example.lapnguyen.lesson8_contentprovider;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.lapnguyen.lesson8_contentprovider.Model.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lapnguyen on 23/05/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private SQLiteDatabase db;
    private static final String TAG = "SQLite";
    static final String DATABASE_NAME="HR";
    static final String EMPLOYEE_TABLE_NAME="Employee";
    static final int DATABASE_VERSION = 1;
    static final String CREATE_DB_TABLE =
            "CREATE TABLE "
                    + EMPLOYEE_TABLE_NAME
                    + "(_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    +"name TEXT NOT NULL ,"
                    + "division TEXT NOT NULL);";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DB_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + EMPLOYEE_TABLE_NAME );
        onCreate(db);
    }
    public int getCount() {
        Log.i(TAG, "DatabaseHelper.getCount ... " );
        SQLiteDatabase db = this.getReadableDatabase();
        String countQuery = "SELECT  * FROM " + EMPLOYEE_TABLE_NAME;
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public List<Employee> getAllEmployee(){
        Log.i(TAG, "DatabaseHelper.getAllEmployee ... " );
        List<Employee> employee = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        // Tao cursor tro vao bang employee
        String selectQuery = "SELECT  * FROM " + EMPLOYEE_TABLE_NAME;
        Cursor cursor = db.rawQuery(selectQuery, null);
        // Dung cursor duyet tren bang va add data vao list.
        if (cursor.moveToFirst()) {
            do {
                employee.add(new Employee(cursor.getInt(0), cursor.getString(1), cursor.getString(2)));
            } while (cursor.moveToNext());
        }
        return employee;
    }
}