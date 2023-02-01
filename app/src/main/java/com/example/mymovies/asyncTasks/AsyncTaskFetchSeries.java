package com.example.mymovies.asyncTasks;

import android.os.AsyncTask;

import com.example.mymovies.controller.ControllerSeries;

public class AsyncTaskFetchSeries extends AsyncTask<String,Void,String> {



    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... strings) {

        ControllerSeries controller = new ControllerSeries();
        String json = controller.getPopularSeries();

        return json;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}