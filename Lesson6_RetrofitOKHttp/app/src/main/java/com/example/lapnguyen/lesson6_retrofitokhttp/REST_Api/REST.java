package com.example.lapnguyen.lesson6_retrofitokhttp.REST_Api;

/**
 * Created by lapnguyen on 18/05/2017.
 */

import com.example.lapnguyen.lesson6_retrofitokhttp.POJO.CarcompanyListPOJO;
import retrofit.Callback;
import retrofit.http.GET;


public class REST {

    public static String BASEURL="https://api.myjson.com";

    public interface api_carCompanies {

        @GET("/bins/hzy19") // specify the sub url for the base url
        void getData(Callback<CarcompanyListPOJO> response); // will give you the json data
    }


}