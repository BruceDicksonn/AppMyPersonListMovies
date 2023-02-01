package com.example.mymovies.utils;

import android.net.Uri;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class NetworkUtils {

    public static void updateArrayGenres(ArrayList<JSONObject> list , ArrayList<JSONObject> listGenres){

        // Altera os valores do genero mudando trocando de IDS para os valores descritivos dos generos

        for(JSONObject object : list) {

            try {

                JSONArray array_genres_id = object.getJSONArray("genre_ids");
                ArrayList<String> array_genres = new ArrayList<>();

                for(int i=0; i < array_genres_id.length();i++) {
                    array_genres.add((String) listGenres.get(i).get("name"));
                }

                object.put("genre_ids", array_genres);
                Log.i("Array", object.toString());


            } catch (JSONException e) {
                e.printStackTrace();
            }


        }

    }

    public static void updateLinksFromPaths(ArrayList<JSONObject> list, String imagePath){

        // atualiza a url das imagens dos objetos json para uma url mais precisa

        for(JSONObject object : list) {

            try {

                // Define uma url mais certeira e prática para os links de imagens
                String backdrop_path = imagePath + object.getString("backdrop_path");
                String poster_path = imagePath + object.getString("poster_path");

                object.put("backdrop_path", backdrop_path);
                object.put("poster_path", poster_path);



            } catch (JSONException e) {
                e.printStackTrace();
            }


        }

    }

    public static void fillList(JSONArray jsonArray, ArrayList<JSONObject> arrayList) {

        for(int i = 0; i < jsonArray.length(); i++) {
            try {
                arrayList.add(jsonArray.getJSONObject(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

}
