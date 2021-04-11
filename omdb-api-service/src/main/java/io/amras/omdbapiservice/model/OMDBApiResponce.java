package io.amras.omdbapiservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class OMDBApiResponce {
    @JsonProperty("Title")
    private String title;
    @JsonProperty("Year")
    private String year;
    @JsonProperty("Rated")
    private String rated;
    @JsonProperty("Released")
    private String released;
    @JsonProperty("Runtime")
    private String runtime;
    @JsonProperty("Genre")
    private String genre;
    @JsonProperty("Director")
    private String director;
    @JsonProperty("Writer")
    private String writer;
    @JsonProperty("Actors")
    private String actors;
    @JsonProperty("Plot")
    private String plot;
    @JsonProperty("Language")
    private String language;
    @JsonProperty("Country")
    private String country;
    @JsonProperty("Awards")
    private String awards;
    @JsonProperty("Poster")
    private String poster;
    @JsonProperty("Ratings")
    private List<Rating> ratings;
    @JsonProperty("Metascore")
    private String metascore;
    private String imdbRating;
    private String imdbVotes;
    private String imdbID;
    @JsonProperty("Response")
    private String response;

    public OMDBApiResponce(String title, String year,
                           String rated, String released,
                           String runtime, String genre,
                           String director, String writer,
                           String actors, String plot,
                           String language, String country,
                           String awards, String poster,
                           List<Rating> ratings, String metascore,
                           String imdbRating, String imdbVotes,
                           String imdbID, String response) {
        this.title = title;
        this.year = year;
        this.rated = rated;
        this.released = released;
        this.runtime = runtime;
        this.genre = genre;
        this.director = director;
        this.writer = writer;
        this.actors = actors;
        this.plot = plot;
        this.language = language;
        this.country = country;
        this.awards = awards;
        this.poster = poster;
        this.ratings = ratings;
        this.metascore = metascore;
        this.imdbRating = imdbRating;
        this.imdbVotes = imdbVotes;
        this.imdbID = imdbID;
        this.response = response;
    }

    public OMDBApiResponce(){}
}