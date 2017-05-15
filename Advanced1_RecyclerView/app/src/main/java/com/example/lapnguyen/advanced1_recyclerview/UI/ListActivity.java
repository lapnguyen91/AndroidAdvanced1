package com.example.lapnguyen.advanced1_recyclerview.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.lapnguyen.advanced1_recyclerview.R;
import com.example.lapnguyen.advanced1_recyclerview.adapter.Adapter;
import com.example.lapnguyen.advanced1_recyclerview.model.Data;

public class ListActivity extends AppCompatActivity {
    private RecyclerView recView;
    private Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recView = (RecyclerView)findViewById(R.id.rec_list);
        //Check out GridLayoutManager and StaggeredGridLayoutManager for more options
        recView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new Adapter(Data.getListData(), this);
        recView.setAdapter(adapter);
    }
}
