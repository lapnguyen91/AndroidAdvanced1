package com.example.lapnguyen.lesson4_imageload.fragment;

/**
 * Created by lapnguyen on 15/05/2017.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.lapnguyen.lesson4_imageload.R;
import com.squareup.picasso.Picasso;

public class PicassoFragment extends Fragment{
    String img ="http://square.github.io/picasso/static/sample.png";

    public PicassoFragment(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container ,Bundle saveInstanceState){
        View view = inflater.inflate(R.layout.fragment_picasso,container,false);
        ImageView ivPicasso = (ImageView) view.findViewById(R.id.ivPicasso);
        Picasso.with(getContext()).load(img).into(ivPicasso);
        return view;
    }
}
