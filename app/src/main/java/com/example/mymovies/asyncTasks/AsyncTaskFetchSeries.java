package com.example.mymovies.asyncTasks;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.util.Log;

import com.example.mymovies.adapters.AdapterFilme;
import com.example.mymovies.adapters.AdapterSerie;
import com.example.mymovies.controller.ControllerSeries;
import com.example.mymovies.model.Filme;
import com.example.mymovies.model.Serie;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class AsyncTaskFetchSeries  extends AsyncTask<Void,Void, ArrayList<Serie>> {

    WeakReference<AdapterSerie> mAdapterSerie;
    WeakReference<ArrayList<Serie>> mList;
    int current_page;

    public AsyncTaskFetchSeries(AdapterSerie adapter, ArrayList<Serie> arrayList, int page) {
        this.mAdapterSerie = new WeakReference<>(adapter);
        this.mList = new WeakReference<>(arrayList);
        this.current_page = page;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected ArrayList<Serie> doInBackground(Void... voids) {

        ControllerSeries controller = new ControllerSeries();
        return controller.getPopularSeries(current_page);

    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onPostExecute(ArrayList<Serie> arrayList) {
        super.onPostExecute(arrayList);

        mList.get().addAll(arrayList);
        mAdapterSerie.get().notifyDataSetChanged();

    }
}