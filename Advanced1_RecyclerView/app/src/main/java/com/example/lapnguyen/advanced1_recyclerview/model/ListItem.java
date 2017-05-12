package com.example.lapnguyen.advanced1_recyclerview.model;

/**
 * Java representation of our Data to be displayed in the RecyclerView
 * Created by lapnguyen on 11/05/2017.
 */

public class ListItem {
    private String title;
    private int imageResId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }
}