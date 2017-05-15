package com.example.lapnguyen.lesson4_imageload.fragment;

/**
 * Created by lapnguyen on 15/05/2017.
 */
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.lapnguyen.lesson4_imageload.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.nostra13.universalimageloader.core.ImageLoader;

public class FrescoFragment extends Fragment{
    public FrescoFragment(){
    }
    SimpleDraweeView sdvFresco;
    String img = "https://cdn1.lockerdome.com/uploads/f85eee1d7d6d3d3799465a517be1efb7b7da9291a1ffd01adb574503f6c692e8_large";

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container ,Bundle saveInstanceState){
        Fresco.initialize(getContext());
        View view = inflater.inflate(R.layout.fragment_fresco,container,false);
        //ImageView igFresco = (ImageView) view.findViewById(igFresco);
        sdvFresco = (SimpleDraweeView) view.findViewById(R.id.sdvFresco);
        final Uri uri = Uri.parse(img);
        sdvFresco.setImageURI(uri);
        return view;
    }
}
