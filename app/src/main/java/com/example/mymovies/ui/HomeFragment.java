package com.example.mymovies.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mymovies.R;
import com.example.mymovies.adapters.AdapterFilme;
import com.example.mymovies.asyncTasks.AsyncTaskFetchMovies;
import com.example.mymovies.dal.DalFilmes;
import com.example.mymovies.databinding.FragmentHomeBinding;
import com.example.mymovies.listeners.EndlessRecyclerViewScrollListener;
import com.example.mymovies.model.Filme;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private ArrayList<Filme> listMovies;
    private AdapterFilme adapterFilme;
    private RecyclerView.LayoutManager manager;
    private int gridColumns = 3;
    EndlessRecyclerViewScrollListener scrollListener;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
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

        binding.recyclerHome.setLayoutManager(manager);
        binding.recyclerHome.setAdapter(adapterFilme);
        binding.recyclerHome.addOnScrollListener(scrollListener);

    }

    @SuppressLint("NotifyDataSetChanged")
    private void initComponents(View view) {

        listMovies = new ArrayList<>();
        adapterFilme = new AdapterFilme(view.getContext(), listMovies);

        new AsyncTaskFetchMovies(adapterFilme,listMovies,1).execute(); // preenche a lista com a page 1 como padrão
        adapterFilme.notifyDataSetChanged();

        gridColumns = getResources().getInteger(R.integer.grid_columns);
        manager = new GridLayoutManager(view.getContext(), gridColumns);

        scrollListener = new EndlessRecyclerViewScrollListener((GridLayoutManager) manager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                Log.i("End", String.valueOf(totalItemsCount));
                Log.i("End", String.valueOf(page));

                page++;
                new AsyncTaskFetchMovies(adapterFilme,listMovies,page).execute();
            }
        };

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(binding != null) binding.recyclerHome.clearOnScrollListeners(); // evitar vazamento de memoria
        return;
    }
}