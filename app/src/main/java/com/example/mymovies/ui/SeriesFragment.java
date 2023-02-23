package com.example.mymovies.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mymovies.R;
import com.example.mymovies.adapters.AdapterPopulares;
import com.example.mymovies.adapters.AdapterSerie;
import com.example.mymovies.asyncTasks.AsyncTaskFetchPopulares;
import com.example.mymovies.asyncTasks.AsyncTaskFetchSeries;
import com.example.mymovies.databinding.FragmentHomeBinding;
import com.example.mymovies.databinding.FragmentSeriesBinding;
import com.example.mymovies.listeners.EndlessRecyclerViewScrollListener;
import com.example.mymovies.model.Popular;
import com.example.mymovies.model.Serie;

import java.util.ArrayList;

public class SeriesFragment extends Fragment {

    private FragmentSeriesBinding binding;
    private ArrayList<Serie> listSeries;
    private AdapterSerie adapterSerie;
    private RecyclerView.LayoutManager manager;
    private int gridColumns = 3;
    private EndlessRecyclerViewScrollListener scrollListener;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentSeriesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initComponents(view);

        binding.recyclerSeries.setLayoutManager(manager);
        binding.recyclerSeries.setAdapter(adapterSerie);
        binding.recyclerSeries.addOnScrollListener(scrollListener);

    }

    @SuppressLint("NotifyDataSetChanged")
    private void initComponents(View view) {

        listSeries = new ArrayList<>();
        adapterSerie = new AdapterSerie(view.getContext(), listSeries);

        new AsyncTaskFetchSeries(adapterSerie,listSeries,1).execute(); // preenche a lista com a page 1 como padrão
        adapterSerie.notifyDataSetChanged();

        gridColumns = getResources().getInteger(R.integer.grid_columns);
        manager = new GridLayoutManager(view.getContext(), gridColumns);

        scrollListener = new EndlessRecyclerViewScrollListener((GridLayoutManager) manager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                Log.i("End", String.valueOf(totalItemsCount));
                Log.i("End", String.valueOf(page));

                page++;
                new AsyncTaskFetchSeries(adapterSerie,listSeries,page).execute();
            }
        };

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(binding != null) binding.recyclerSeries.clearOnScrollListeners(); // evitar vazamento de memoria
        return;
    }
}