package com.example.lapnguyen.lesson6_retrofitokhttp.Adapter;

/**
 * Created by lapnguyen on 18/05/2017.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lapnguyen.lesson6_retrofitokhttp.POJO.Carcompany;
import com.example.lapnguyen.lesson6_retrofitokhttp.R;

import java.util.List;
public class Adapter extends BaseAdapter {

    List<Carcompany> companies;
    Context context;
    private static LayoutInflater inflater = null;

    public Adapter(Context mainActivity, List<Carcompany> c) {
        companies = c;
        context = mainActivity;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return companies.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }




    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        View listItemView;
        listItemView = inflater.inflate(R.layout.list_item, null);

        //Set the name of company in the list item textview
        TextView name = (TextView) listItemView.findViewById(R.id.company_name);
        name.setText(companies.get(position).getCompanyName());


        return listItemView;
    }


}