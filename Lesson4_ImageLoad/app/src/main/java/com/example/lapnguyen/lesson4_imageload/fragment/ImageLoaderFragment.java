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
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class ImageLoaderFragment extends Fragment{
    ImageLoader imageLoader;

    String url="http://static.cleverstore.vn/icon/2015/02/cbd7d0756bb74f3f8fdcf1d27e827594.png";

    public ImageLoaderFragment(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container ,Bundle saveInstanceState){

        View view = inflater.inflate(R.layout.fragment_imageloader,container,false);
        ImageView ivImageloader = (ImageView) view.findViewById(R.id.ivImageloader);
        imageLoader =ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(getContext()));
        imageLoader.displayImage(url,ivImageloader);
        return view;
    }
}
