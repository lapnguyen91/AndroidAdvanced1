package com.example.lapnguyen.lesson6_retrofitokhttp.POJO;

/**
 * Created by lapnguyen on 18/05/2017.
 */
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CarcompanyListPOJO {

    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("carcompanies")
    @Expose
    private List<Carcompany> carcompanies = null;

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public List<Carcompany> getCarcompanies() {
        return carcompanies;
    }

    public void setCarcompanies(List<Carcompany> carcompanies) {
        this.carcompanies = carcompanies;
    }

}
