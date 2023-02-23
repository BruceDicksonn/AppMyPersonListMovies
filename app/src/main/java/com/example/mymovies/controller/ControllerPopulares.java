package com.example.mymovies.controller;

import com.example.mymovies.dal.DalPopulares;
import com.example.mymovies.model.Popular;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;

public class ControllerPopulares {

    public ArrayList<Popular> getTrending(int page) {

        ArrayList<Popular> trending = new ArrayList<>();
        ArrayList<JSONObject> listMovies = DalPopulares.getTrendingItems(page);

        for(JSONObject object : listMovies) {

            Gson gson = new Gson();
            Popular popular = gson.fromJson(object.toString(), Popular.class);
            trending.add(popular);

        }


        return trending;
    }

}
