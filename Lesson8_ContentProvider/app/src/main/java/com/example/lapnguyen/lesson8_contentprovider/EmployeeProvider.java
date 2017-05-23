package com.example.lapnguyen.lesson8_contentprovider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.example.lapnguyen.lesson8_contentprovider.DatabaseHelper;
import java.util.HashMap;

/**
 * Created by lapnguyen on 23/05/2017.
 */

public class EmployeeProvider extends ContentProvider {

    static final String PROVIDER_NAME = "com.example.lapnguyen.lesson8_contentprovider.HR";
    static final String URI = "content://" + PROVIDER_NAME + "/employee";
    static final Uri CONTENT_URI = Uri.parse(URI);

    static final String _ID = "_id";
    static final String NAME = "name";
    static final String DIVISION = "division";

    private static HashMap<String, String> EMPLOYEE_PROJECTION_MAP;

    static final int EMPLOYEE = 1;
    static final int EMPLOYEE_ID = 2;
    //Cong dung
    static final UriMatcher uriMatcher;
    static{
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(PROVIDER_NAME, "employee", EMPLOYEE);
        uriMatcher.addURI(PROVIDER_NAME, "employee/#", EMPLOYEE_ID);
    }

    private SQLiteDatabase db;
    static final String DATABASE_NAME="HR";
    static final String EMPLOYEE_TABLE_NAME="Employee";
    static final int DATABASE_VERSION = 1;
    static final String CREATE_DB_TABLE = "CREATE TABLE " + EMPLOYEE_TABLE_NAME + "(_id INTEGER PRIMARY KEY AUTOINCREMENT, "+"name TEXT NOT NULL ," + "division TEXT NOT NULL);";



    @Override
    public boolean onCreate() {
        Context context = getContext();
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
        return (db == null) ? false:true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        SQLiteQueryBuilder  qb = new SQLiteQueryBuilder();
        qb.setTables(EMPLOYEE_TABLE_NAME);
        switch (uriMatcher.match(uri)){
            case EMPLOYEE:
                qb.setProjectionMap(EMPLOYEE_PROJECTION_MAP);
                break;
            case EMPLOYEE_ID:
                qb.appendWhere(_ID + "=" + uri.getPathSegments().get(1) );
                break;
            default:
                throw new IllegalArgumentException("Unknown URI");
        }
        if(sortOrder == null || sortOrder == ""){
            sortOrder=NAME;
        }
        Cursor c = qb.query(db,projection,selection,selectionArgs,null,null,sortOrder);
                c.setNotificationUri(getContext().getContentResolver(),uri);
        return c;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        long rowID = db.insert(EMPLOYEE_TABLE_NAME, "", values);
        if(rowID > 0){
            Uri _uri = ContentUris.withAppendedId(CONTENT_URI, rowID);
            getContext().getContentResolver().notifyChange(_uri, null);
            return _uri;
        }
        throw new SQLException("Failed to add a record into " + uri);
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        int count = 0;

        switch (uriMatcher.match(uri)){
            case EMPLOYEE:
                count = db.delete(EMPLOYEE_TABLE_NAME, selection, selectionArgs);
                break;
            case EMPLOYEE_ID:
                count = db.delete(EMPLOYEE_TABLE_NAME, _ID + "=" + uri.getPathSegments().get(1) +
                        (!TextUtils.isEmpty(selection) ? " AND (" +
                                selection + ')': ""), selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return count;

    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        int count = 0;

        switch (uriMatcher.match(uri)){
            case EMPLOYEE:
                count = db.update(EMPLOYEE_TABLE_NAME, values, selection, selectionArgs);
                break;
            case EMPLOYEE_ID:
                count = db.update(EMPLOYEE_TABLE_NAME, values, _ID + "=" + uri.getPathSegments().get(1) +
                        (!TextUtils.isEmpty(selection) ? " AND (" +
                                selection + ')': ""), selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }
}
