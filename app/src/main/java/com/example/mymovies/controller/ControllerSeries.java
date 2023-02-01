package com.example.mymovies.controller;

import com.example.mymovies.dal.DalSeries;

import org.json.JSONObject;
import java.util.ArrayList;

public class ControllerSeries {

    public String getPopularSeries() {

        ArrayList<JSONObject> json = DalSeries.getSeries();

        return json.toString();
    }
}
