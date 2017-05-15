package com.example.lapnguyen.lesson5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class NextActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.next_page);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.itemHome:
                Intent home = new Intent(this, MainActivity.class);
                startActivity(home);
                break;
            case R.id.itemNext:
                Intent page1 = new Intent(this, NextActivity.class);
                startActivity(page1);
                break;
            case R.id.itemLast:
                Intent page2 = new Intent(this, LastActivity.class);
                startActivity(page2);
        }
        return super.onOptionsItemSelected(item);
    }
}
