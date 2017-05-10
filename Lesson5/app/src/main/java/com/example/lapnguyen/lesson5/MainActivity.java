package com.example.lapnguyen.lesson5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private Button btnPopUpMenu;
    private ListView lv;
    private ArrayAdapter<String> adapter;
    private EditText inputSearch;
    private ArrayList<HashMap<String, String>> productList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initWidget();
        //setEventClickViews();
        String products[] = {"Dell Inspiron", "HTC One X", "HTC Wildfire S", "HTC Sense", "HTC Sensation XE",
                "iPhone 4S", "Samsung Galaxy Note 800",
                "Samsung Galaxy S3", "MacBook Air", "Mac Mini", "MacBook Pro"};

        lv = (ListView) findViewById(R.id.list_view);
        inputSearch = (EditText) findViewById(R.id.inputSearch);

        adapter = new ArrayAdapter<String>(this, R.layout.item_list, R.id.product_name, products);
        lv.setAdapter(adapter);

        inputSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text
                MainActivity.this.adapter.getFilter().filter(cs);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
            }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.my_menu, menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    public void initWidget() {
//        btnPopUpMenu = (Button) findViewById(R.id.btnPopUpMenu);
//    }
//
//    public void setEventClickViews() {
//        btnPopUpMenu.setOnClickListener(this);
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.itemHome:
//                Intent home = new Intent(this, MainActivity.class);
//                startActivity(home);
//                break;
//            case R.id.itemNext:
//                Intent page1 = new Intent(this, NextActivity.class);
//                startActivity(page1);
//                break;
//            case R.id.itemLast:
//                Intent page2 = new Intent(this, LastActivity.class);
//                startActivity(page2);
//        }
//        return super.onOptionsItemSelected(item);
//    }

//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.btnPopUpMenu:
//                PopupMenu popup = new PopupMenu(MainActivity.this, btnPopUpMenu);
//                popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());
//
//                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//                    public boolean onMenuItemClick(MenuItem item) {
//                        Toast.makeText(MainActivity.this,"You Clicked : " + item.getTitle(),Toast.LENGTH_SHORT).show();
//                        return true;
//                    }
//                });
//                popup.show();
//        }
//    }

        });
    }
}



