package com.example.lapnguyen.lesson4_imageload;

/**
 * Created by lapnguyen on 15/05/2017.
 */
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.lapnguyen.lesson4_imageload.fragment.*;

public class Adapter extends FragmentPagerAdapter{

    public Adapter(FragmentManager fm)
    {
        super (fm);
    }

    @Override
    public Fragment getItem(int position){
        Fragment fragment = null;
        switch (position)
        {
            case 0:
                fragment = new FrescoFragment();
                break;
            case 1:
                fragment = new GlideFragment();
                break;
            case 2:
                fragment = new ImageLoaderFragment();
                break;
            case 3:
                fragment = new PicassoFragment();
                break;
        }
        return fragment;
    }
    @Override
    public int getCount(){return 4;}

    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){
            case 0:
                title = "Fresco";
                break;
            case 1:
                title = "Glide";
                break;
            case 2:
                title = "I-Loader";
                break;
            case 3:
                title = "Picasso";
                break;
        }
        return title;
    }
}
