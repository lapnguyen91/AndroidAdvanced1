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

import com.bumptech.glide.Glide;
import com.example.lapnguyen.lesson4_imageload.R;

public class GlideFragment extends Fragment{
    String img = "https://raw.githubusercontent.com/bumptech/glide/master/static/glide_logo.png";

    public GlideFragment(){
    }
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container ,Bundle saveInstanceState){

        View view = inflater.inflate(R.layout.fragment_glide,container,false);
        ImageView ivGlide = (ImageView) view.findViewById(R.id.ivGlide);

        Glide.with(this).load(img).into(ivGlide);

        return view;
    }

}
