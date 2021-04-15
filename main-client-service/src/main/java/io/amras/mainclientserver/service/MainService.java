package io.amras.mainclientserver.service;

import io.amras.mainclientserver.model.MovieRequest;
import io.amras.mainclientserver.model.MoviedbSearchMovieResponse;
import io.amras.mainclientserver.model.OMDBApiResponce;
import io.amras.mainclientserver.model.SearchedMovieDetails;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@Log4j2
public class MainService {
    @Value("${services.omdb.api.url}")
    private String omdb_apiUrl;
    @Value("${services.moviedb.api.url}")
    private String moviedb_apiUrl;

    @Autowired
    private RestTemplate restTemplate;

    public MoviedbSearchMovieResponse findMovie(MovieRequest movieRequest){
        log.info(String.format("Sending [POST] to %smovie with body = %s", moviedb_apiUrl, movieRequest.toString()));

        MoviedbSearchMovieResponse response = restTemplate.postForObject(moviedb_apiUrl + "/movies",
                movieRequest,
                MoviedbSearchMovieResponse.class);

        for (SearchedMovieDetails details : response.getResults()) {
            details.setPoster_path("https://image.tmdb.org/t/p/w500" + details.getPoster_path());
        }

        log.info(String.format("Got answer response = %s", response.toString()));

        return response;
    }

    public String getMovieImdbId(int movieId){
        String requestImdbIdURI = UriComponentsBuilder.fromHttpUrl(moviedb_apiUrl + "/movies")
                .queryParam("id", movieId)
                .build(false).toUriString();

        log.info(String.format("Sending [GET] to %s in order to find imdbId by id = %d", requestImdbIdURI, movieId));

        String imdbId = restTemplate.getForObject(requestImdbIdURI, String.class);

        log.info(String.format("From moviedb-api-service got answer with imdbId = %s", imdbId));

        return imdbId;
    }

    public OMDBApiResponce getMovieInfoByImdbId(String imdbId){
        String requestOmdbApiURI = UriComponentsBuilder.fromHttpUrl(omdb_apiUrl + "/movie")
                .queryParam("imdbId", imdbId)
                .build(false).toUriString();

        log.info(String.format("[GET] request for omdb-api-service %s", requestOmdbApiURI));

        OMDBApiResponce responce = restTemplate.getForObject(requestOmdbApiURI, OMDBApiResponce.class);

        log.info(String.format("Got answer = %s", responce));

        return responce;
    }
}
