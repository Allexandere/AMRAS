package io.amras.omdbapiservice.model;

import lombok.Data;

import java.util.List;

@Data
public class MoviedbSearchMovieResponse {
    public int page;
    public List<SearchedMovieDetails> results;
    public int total_pages;
    public int total_results;
}
