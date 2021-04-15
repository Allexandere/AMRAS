package io.amras.mainclientserver.model;

import lombok.Data;

import java.util.List;

@Data
public class MoviedbSearchMovieResponse {
    private int page;
    private List<SearchedMovieDetails> results;
    private int total_pages;
    private int total_results;
}
