package io.amras.mainclientserver.model;

import lombok.Data;

import java.util.List;

@Data
public class SearchedMovieDetails {
    private String backdrop_path;
    private List<Integer> genre_ids;
    private int id;
    private String original_language;
    private String original_title;
    private String overview;
    private double popularity;
    private String poster_path;
    private String release_date;
    private String title;
    private boolean video;
    private double vote_average;
    private int vote_count;
    private String service_link;
}
