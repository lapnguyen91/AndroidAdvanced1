package com.example.lapnguyen.lesson6_retrofitokhttp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ListView;

import com.example.lapnguyen.lesson6_retrofitokhttp.Adapter.Adapter;
import com.example.lapnguyen.lesson6_retrofitokhttp.POJO.Carcompany;
import com.example.lapnguyen.lesson6_retrofitokhttp.POJO.CarcompanyListPOJO;
import com.example.lapnguyen.lesson6_retrofitokhttp.REST_Api.REST;

public class MainActivity extends AppCompatActivity {

    // NOTE: Global Declaration
    List<Carcompany> list_car_company;  // Hold the list of car companies
    ListView lv;
     List<Carcompany> listData = new ArrayList<Carcompany>();
     RecyclerView recyclerView;

     RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // NOTE : initializing
        lv=(ListView) findViewById(R.id.listView);

        restCall();
    }

    //---------------------------------REST-----------------------------------------------------//
    private void restCall() {

        //Creating a rest adapter
        final RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(REST.BASEURL)
                .build();
        REST.api_carCompanies api = adapter.create(REST.api_carCompanies.class);

        //Defining the method
        api.getData(new Callback<CarcompanyListPOJO>() {
            @Override
            public void success( CarcompanyListPOJO  car_list_response , Response response) {
                if (car_list_response != null){

                    list_car_company = car_list_response.getCarcompanies();  // Takes list of car from Response

                    //Loads List View
                    Adapter arrayAdapter = new Adapter(getBaseContext(), list_car_company);
                    lv.setAdapter(arrayAdapter);
                }
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("Failed to Connect REST",""+error.getCause());
            }
        });

        //---------------------*** END REST ***-----------------------------------------------------//


    }
}