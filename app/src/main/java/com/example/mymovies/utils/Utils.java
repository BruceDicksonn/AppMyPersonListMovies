package com.example.mymovies.utils;

import android.content.Context;

import androidx.core.content.ContextCompat;

import com.example.mymovies.R;
import com.facebook.shimmer.Shimmer;

public class Utils {

    public static String api_key = "b1b6e61282d804726cefb2f18f8a997e";

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

}
