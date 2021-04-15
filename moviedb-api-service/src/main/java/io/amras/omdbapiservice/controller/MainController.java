package io.amras.omdbapiservice.controller;

import io.amras.omdbapiservice.model.MovieDetail;
import io.amras.omdbapiservice.model.MovieRequest;
import io.amras.omdbapiservice.model.MoviedbSearchMovieResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@Log4j2
public class MainController {

    @Value("${moviedb.api.url.v3}")
    private String apiUrlv3;
    @Value("${moviedb.api.api_key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/movies")
    public MoviedbSearchMovieResponse getMovieInfo(@RequestBody MovieRequest movieRequest) {
        log.info(String.format("Got [POST] request for getMovieInfo with body %s", movieRequest.toString()));

        String requestURI = UriComponentsBuilder.fromHttpUrl(apiUrlv3 + "/search/movie")
                .queryParam("api_key", apiKey)
                .queryParam("language", "en-US")
                .queryParam("query", movieRequest.getSearchKeyword())
                .queryParam("year", movieRequest.getYear())
                .build(false).toUriString();

        MoviedbSearchMovieResponse response = restTemplate.getForObject(requestURI, MoviedbSearchMovieResponse.class);

        log.info(String.format("Made %s request, got answer with body %s", requestURI, response.toString()));

        return response;
    }

    @GetMapping("/movies")
    public String getMovieImdbId(@RequestParam("id") int id) {

        String requestURI = UriComponentsBuilder.fromHttpUrl(apiUrlv3 + "/movie/" + id)
                .queryParam("api_key", apiKey)
                .queryParam("language", "en-US")
                .build(false).toUriString();

        log.info(String.format("Got [GET] request for getMovieImdbId with id=%d, requesting %s", id, requestURI));

        MovieDetail response = restTemplate.getForObject(requestURI, MovieDetail.class);

        log.info(String.format("Made %s request, got answer with body %s", requestURI, response.toString()));

        return response.getImdb_id();
    }
}
