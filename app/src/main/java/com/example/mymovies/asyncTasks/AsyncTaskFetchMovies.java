package com.example.mymovies.asyncTasks;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.util.Log;
import com.example.mymovies.adapters.AdapterFilme;
import com.example.mymovies.controller.ControllerFilmes;
import com.example.mymovies.model.Filme;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class AsyncTaskFetchMovies extends AsyncTask<Void,Void,ArrayList<Filme>> {

    WeakReference<AdapterFilme> mAdapterFilme;
    WeakReference<ArrayList<Filme>> mList;
    int current_page;


    public AsyncTaskFetchMovies(AdapterFilme adapter, ArrayList<Filme> arrayList, int page) {
        this.mAdapterFilme = new WeakReference<>(adapter);
        this.mList = new WeakReference<>(arrayList);
        this.current_page = page;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected ArrayList<Filme> doInBackground(Void... voids) {
        ControllerFilmes controllerFilmes = new ControllerFilmes();
        return controllerFilmes.getPopularMovies(current_page);
    }


    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onPostExecute(ArrayList<Filme> arrayList) {
        super.onPostExecute(arrayList);

        mList.get().addAll(arrayList);
        mAdapterFilme.get().notifyDataSetChanged();
        Log.i("AsyncTask","123");

    }
}
