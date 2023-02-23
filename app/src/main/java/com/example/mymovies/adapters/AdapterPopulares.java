package com.example.mymovies.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mymovies.R;
import com.example.mymovies.model.Popular;
import com.example.mymovies.utils.Utils;
import com.facebook.shimmer.Shimmer;
import com.facebook.shimmer.ShimmerDrawable;

import java.util.ArrayList;

public class AdapterPopulares extends RecyclerView.Adapter<AdapterPopulares.AdapterItemHolder>  {


    Context context;
    ArrayList<Popular> list;

    public AdapterPopulares(Context context, ArrayList<Popular> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public AdapterPopulares.AdapterItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.adapter_item,parent,false);
        return new AdapterPopulares.AdapterItemHolder(view);

    }

    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(@NonNull AdapterPopulares.AdapterItemHolder holder, int position) {

        Popular item = list.get(position);

        /* Criados para dar um efeito suave de loading */
        Shimmer shimmer = Utils.createNewShimmer(context);
        ShimmerDrawable drawable = new ShimmerDrawable();
        drawable.setShimmer(shimmer);

        Glide.with(context)
                .load(item.getPoster_path())
                .placeholder(drawable)
                .into(holder.posterItem);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class AdapterItemHolder extends RecyclerView.ViewHolder {

        ImageView posterItem;

        public AdapterItemHolder(@NonNull View itemView) {
            super(itemView);

            posterItem = itemView.findViewById(R.id.posterItem);

        }
    }

}
