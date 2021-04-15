package io.amras.omdbapiservice.model;

import lombok.Data;

import java.util.List;

@Data
public class SearchedMovieDetails {
    public String backdrop_path;
    public List<Integer> genre_ids;
    public int id;
    public String original_language;
    public String original_title;
    public String overview;
    public double popularity;
    public String poster_path;
    public String release_date;
    public String title;
    public boolean video;
    public double vote_average;
    public int vote_count;
}
