package com.example.mymovies.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.mymovies.databinding.FragmentFilmesBinding;

public class FilmesFragment extends Fragment {

    private FragmentFilmesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

//        FilmesViewModel filmesViewModel =
//                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(FilmesViewModel.class);

        binding = FragmentFilmesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        final TextView textView = binding.textGallery;
//        filmesViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}