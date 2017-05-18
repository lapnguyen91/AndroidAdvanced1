package com.example.lapnguyen.lesson6_retrofitokhttp.POJO;

/**
 * Created by lapnguyen on 18/05/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Carcompany {

    @SerializedName("company_name")
    //SerializedName dung de anh xa du lieu cua khoa json company_name toi truong du lieu companyName trong java
    //
    @Expose
    private String companyName;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

}