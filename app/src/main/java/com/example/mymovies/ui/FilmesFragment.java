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
import com.example.mymovies.adapters.AdapterFilme;
import com.example.mymovies.adapters.AdapterPopulares;
import com.example.mymovies.asyncTasks.AsyncTaskFetchFilmes;
import com.example.mymovies.asyncTasks.AsyncTaskFetchPopulares;
import com.example.mymovies.databinding.FragmentFilmesBinding;
import com.example.mymovies.databinding.FragmentHomeBinding;
import com.example.mymovies.listeners.EndlessRecyclerViewScrollListener;
import com.example.mymovies.model.Filme;
import com.example.mymovies.model.Popular;

import java.util.ArrayList;

public class FilmesFragment extends Fragment {

    private FragmentFilmesBinding binding;
    private ArrayList<Filme> listFilmes;
    private AdapterFilme adapterFilmes;
    private RecyclerView.LayoutManager manager;
    private int gridColumns = 3;
    private EndlessRecyclerViewScrollListener scrollListener;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentFilmesBinding.inflate(inflater, container, false);
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

        binding.recyclerMovies.setLayoutManager(manager);
        binding.recyclerMovies.setAdapter(adapterFilmes);
        binding.recyclerMovies.addOnScrollListener(scrollListener);

    }

    @SuppressLint("NotifyDataSetChanged")
    private void initComponents(View view) {

        listFilmes = new ArrayList<>();
        adapterFilmes = new AdapterFilme(view.getContext(), listFilmes);

        new AsyncTaskFetchFilmes(adapterFilmes,listFilmes,1).execute(); // preenche a lista com a page 1 como padrão
        adapterFilmes.notifyDataSetChanged();

        gridColumns = getResources().getInteger(R.integer.grid_columns);
        manager = new GridLayoutManager(view.getContext(), gridColumns);

        scrollListener = new EndlessRecyclerViewScrollListener((GridLayoutManager) manager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                Log.i("End", String.valueOf(totalItemsCount));
                Log.i("End", String.valueOf(page));

                page++;
                new AsyncTaskFetchFilmes(adapterFilmes,listFilmes,page).execute();
            }
        };

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(binding != null) binding.recyclerMovies.clearOnScrollListeners(); // evitar vazamento de memoria
        return;
    }
}