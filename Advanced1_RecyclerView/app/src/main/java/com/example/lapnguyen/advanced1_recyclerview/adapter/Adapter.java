package com.example.lapnguyen.advanced1_recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lapnguyen.advanced1_recyclerview.R;
import com.example.lapnguyen.advanced1_recyclerview.model.ListItem;

import java.util.List;


/**
 * Created by lapnguyen on 11/05/2017.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.Holder> {

    private List<ListItem> listData;
    private LayoutInflater inflater;

    public Adapter(List<ListItem> listData, Context c){
        inflater = LayoutInflater.from(c);
        this.listData = listData;
    }


    @Override
    public Adapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        ListItem item = listData.get(position);
        holder.title.setText(item.getTitle());
        holder.icon.setImageResource(item.getImageResId());
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    class Holder extends RecyclerView.ViewHolder {

        private TextView title;
        private ImageView icon;
        private View container;

        public Holder(View itemView) {
            super(itemView);

            title = (TextView)itemView.findViewById(R.id.lbl_item_text);
            icon = (ImageView)itemView.findViewById(R.id.im_item_icon);
            //We'll need the container later on, when we add an View.OnClickListener
            container = itemView.findViewById(R.id.cont_item_root);
        }
    }
}
