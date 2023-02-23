package com.example.mymovies.asyncTasks;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.util.Log;

import com.example.mymovies.adapters.AdapterPopulares;
import com.example.mymovies.controller.ControllerPopulares;
import com.example.mymovies.model.Popular;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class AsyncTaskFetchPopulares extends AsyncTask<Void,Void,ArrayList<Popular>> {

    WeakReference<AdapterPopulares> mAdapterPopular;
    WeakReference<ArrayList<Popular>> mList;
    int current_page;


    public AsyncTaskFetchPopulares(AdapterPopulares adapter, ArrayList<Popular> arrayList, int page) {
        this.mAdapterPopular = new WeakReference<>(adapter);
        this.mList = new WeakReference<>(arrayList);
        this.current_page = page;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected ArrayList<Popular> doInBackground(Void... voids) {
        ControllerPopulares controllerPopulares = new ControllerPopulares();
        return controllerPopulares.getTrending(current_page);
    }


    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onPostExecute(ArrayList<Popular> arrayList) {
        super.onPostExecute(arrayList);

        mList.get().addAll(arrayList);
        mAdapterPopular.get().notifyDataSetChanged();

    }

}
