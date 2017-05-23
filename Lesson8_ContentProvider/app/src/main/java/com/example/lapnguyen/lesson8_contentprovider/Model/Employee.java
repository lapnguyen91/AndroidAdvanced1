package com.example.lapnguyen.lesson8_contentprovider.Model;

/**
 * Created by lapnguyen on 23/05/2017.
 */

public class Employee {
    private int id;
    private String name;
    private String division;

    public Employee(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public Employee(int id, String name, String division) {
        this.id = id;
        this.name = name;
        this.division = division;
    }

}
