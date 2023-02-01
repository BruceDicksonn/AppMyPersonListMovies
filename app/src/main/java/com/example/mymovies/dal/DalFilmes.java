package com.example.mymovies.dal;

import android.net.Uri;
import android.util.Log;

import com.example.mymovies.utils.NetworkUtils;
import com.example.mymovies.utils.Utils;

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

public class DalFilmes {

    static final String API_KEY = "api_key";
    static final String LANGUAGE = "language";
    static final String PAGE = "page";
    static final String REQUEST_IMAGE_PATH = "https://image.tmdb.org/t/p/w500/";

    static final String REQUEST_POPULAR_MOVIES = "https://api.themoviedb.org/3/movie/popular?";
    static final String REQUEST_GENRES_MOVIES = "https://api.themoviedb.org/3/genre/movie/list?";

    static ArrayList<JSONObject> listMovies = new ArrayList<>();
    static ArrayList<JSONObject> listGenres = new ArrayList<>();

    public static ArrayList<JSONObject> getMovies(int page){

        if(listMovies.size() != 0 || listGenres.size() != 0) {
            listMovies.clear();
            listGenres.clear();
        }

        initRequests(page);

        NetworkUtils.updateLinksFromPaths(listMovies, REQUEST_IMAGE_PATH);
        NetworkUtils.updateArrayGenres(listMovies, listGenres);

        return listMovies;

    }

    private static void initRequests(int page){
        requestPopularMovies(page);
        requestGenresMovies();
    }

    private static String requestPopularMovies(int page){

        HttpURLConnection httpURLConnection = null;
        BufferedReader reader = null;
        Uri builtUri = null;
        String jsonResponse = null;

        try {


            builtUri = Uri.parse(REQUEST_POPULAR_MOVIES).buildUpon()
                    .appendQueryParameter(API_KEY, Utils.api_key)
                    .appendQueryParameter(LANGUAGE,"pt-BR")
                    .appendQueryParameter(PAGE, String.valueOf(page))
                    .build();

            URL urlRequest = new URL(builtUri.toString());

            httpURLConnection = (HttpURLConnection) urlRequest.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();


            InputStream inputStream = httpURLConnection.getInputStream();

            reader = new BufferedReader(new InputStreamReader(inputStream));

            StringBuilder stringBuilder = new StringBuilder("");
            String row;

            while((row = reader.readLine()) != null){

                stringBuilder.append(row);
                stringBuilder.append("\n");

            }

            if(stringBuilder.length() == 0) {
                return null;
            }

            jsonResponse = stringBuilder.toString();

            JSONObject jsonObject = new JSONObject(jsonResponse);
            JSONArray jsonArray = jsonObject.getJSONArray("results");

            NetworkUtils.fillList(jsonArray, listMovies);

            Log.d("Script", jsonResponse);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {

            if(httpURLConnection != null) httpURLConnection.disconnect();

            if(reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        return jsonResponse;
    }

    private static String requestGenresMovies(){

        HttpURLConnection httpURLConnection = null;
        BufferedReader reader = null;
        String json = "";

        try {

            Uri uri = Uri.parse(REQUEST_GENRES_MOVIES).buildUpon()
                    .appendQueryParameter(API_KEY,Utils.api_key)
                    .build();

            URL url = new URL(uri.toString());

            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();

            InputStream inputStream = httpURLConnection.getInputStream();

            reader = new BufferedReader(new InputStreamReader(inputStream));

            StringBuilder builder = new StringBuilder("");

            String row = "";
            while((row = reader.readLine()) != null) {

                builder.append(row);
                builder.append("\n");

            }

            if(builder.length() == 0) {
                return "";
            }

            json = builder.toString();

            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("genres");

            NetworkUtils.fillList(jsonArray, listGenres);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {

            if(httpURLConnection != null) httpURLConnection.disconnect();

            if(reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }


        return json;

    }


}
