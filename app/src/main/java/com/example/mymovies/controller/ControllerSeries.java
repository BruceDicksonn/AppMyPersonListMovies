package com.example.mymovies.controller;

import com.example.mymovies.dal.DalFilmes;
import com.example.mymovies.dal.DalSeries;
import com.example.mymovies.model.Filme;
import com.example.mymovies.model.Serie;
import com.google.gson.Gson;

import org.json.JSONObject;
import java.util.ArrayList;

public class ControllerSeries {

    public ArrayList<Serie> getPopularSeries(int page) {

        ArrayList<Serie> series = new ArrayList<>();
        ArrayList<JSONObject> listSeries = DalSeries.getSeries(page);

        for(JSONObject object : listSeries) {

            Gson gson = new Gson();
            Serie serie = gson.fromJson(object.toString(), Serie.class);

            series.add(serie);

        }


        return series;
    }
}
