package com.example.mymovies.utils;

import android.content.Context;
import android.util.Log;
import android.view.Menu;

import androidx.core.content.ContextCompat;

import com.example.mymovies.R;
import com.example.mymovies.view.MainActivity;
import com.facebook.shimmer.Shimmer;
import com.ferfalk.simplesearchview.SimpleSearchView;

public class Utils {

    public static String api_key = "XXXXXXXXXXXXXXXXXXXXXXXXX";

    public static Shimmer createNewShimmer(Context context){

        Shimmer shimmer = new Shimmer.ColorHighlightBuilder()
                .setBaseColor(ContextCompat.getColor(context, R.color.light_black))
                .setBaseAlpha(1)
                .setHighlightColor(ContextCompat.getColor(context,R.color.dark_gray))
                .setHighlightAlpha(1)
                .setDropoff(50)
                .build();

        return shimmer;
    }

    public static void hideMenuItems(Menu menu){
        for(int i=0; i < menu.size();i++){
            menu.getItem(i).setVisible(false);
        }
    }

    public static void showMenuItems(Menu menu){
        for(int i=0; i < menu.size();i++){
            menu.getItem(i).setVisible(true);
        }
    }

}
