package com.example.mymovies.controller;
import com.example.mymovies.dal.DalFilmes;
import com.example.mymovies.model.Filme;
import com.google.gson.Gson;

import org.json.JSONObject;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class ControllerFilmes {

    public ArrayList<Filme> getPopularMovies(int page) {

        ArrayList<Filme> filmes = new ArrayList<>();
        ArrayList<JSONObject> listMovies = DalFilmes.getMovies(page);

        for(JSONObject object : listMovies) {

            Gson gson = new Gson();
            Filme filme = gson.fromJson(object.toString(), Filme.class);

            filmes.add(filme);

        }


        return filmes;
    }

}
