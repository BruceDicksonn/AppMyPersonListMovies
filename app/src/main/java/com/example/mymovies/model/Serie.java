package com.example.mymovies.model;

import java.io.Serializable;

public class Serie implements Serializable {

    private String backdrop_path;
    private String first_air_date;
    private String genre_ids;
    private long id;
    private String name;
    private String[] origin_country;
    private String original_language;
    private String original_name;
    private String overview;
    private double popularity;
    private String poster_path;
    private double vote_average;
    private long vote_count;

    public Serie(String backdrop_path, String first_air_date, String genre_ids, long id, String name, String[] origin_country, String original_language, String original_name, String overview, double popularity, String poster_path, double vote_average, long vote_count) {
        this.backdrop_path = backdrop_path;
        this.first_air_date = first_air_date;
        this.genre_ids = genre_ids;
        this.id = id;
        this.name = name;
        this.origin_country = origin_country;
        this.original_language = original_language;
        this.original_name = original_name;
        this.overview = overview;
        this.popularity = popularity;
        this.poster_path = poster_path;
        this.vote_average = vote_average;
        this.vote_count = vote_count;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public String getFirst_air_date() {
        return first_air_date;
    }

    public void setFirst_air_date(String first_air_date) {
        this.first_air_date = first_air_date;
    }

    public String getGenre_ids() {
        return genre_ids;
    }

    public void setGenre_ids(String genre_ids) {
        this.genre_ids = genre_ids;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getOrigin_country() {
        return origin_country;
    }

    public void setOrigin_country(String[] origin_country) {
        this.origin_country = origin_country;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getOriginal_name() {
        return original_name;
    }

    public void setOriginal_name(String original_name) {
        this.original_name = original_name;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }

    public long getVote_count() {
        return vote_count;
    }

    public void setVote_count(long vote_count) {
        this.vote_count = vote_count;
    }
}

/**
 * {
 *   "backdrop_path": "https://image.tmdb.org/t/p/w500//uDgy6hyPd82kOHh6I95FLtLnj6p.jpg",
 *   "first_air_date": "2023-01-15",
 *   "genre_ids": "[The Last of Us, Való Világ, Wandinha]",
 *   "id": 100088,
 *   "name": "The Last of Us",
 *   "origin_country": ["US"],
 *   "original_language": "en",
 *   "original_name": "The Last of Us",
 *   "overview": "Situado duas décadas após a implosão de nossa sociedade, o drama seguirá Joel, um sobrevivente difícil, que é contratado para contrabandear uma garota de 14 anos chamada Ellie para fora de uma zona de quarentena opressiva. O que começa como um pequeno trabalho logo se torna uma jornada brutal e de partir o coração, já que os dois precisam atravessar os Estados Unidos e dependem um do outro para sobreviver.",
 *   "popularity": 9681.188,
 *   "poster_path": "https://image.tmdb.org/t/p/w500//uKvVjHNqB5VmOrdxqAt2F7J78ED.jpg",
 *   "vote_average": 9,
 *   "vote_count": 792
 * }
 * */