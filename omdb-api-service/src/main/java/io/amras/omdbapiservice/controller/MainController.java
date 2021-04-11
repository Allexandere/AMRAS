package io.amras.omdbapiservice.controller;

import io.amras.omdbapiservice.model.MovieRequest;
import io.amras.omdbapiservice.model.OMDBApiResponce;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@Log4j2
public class MainController {

    @Value("${omdb.api.url}")
    private String apiUrl;
    @Value("${omdb.api.apikey}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/movie")
    public OMDBApiResponce getMovieInfo(@RequestBody MovieRequest movieRequest)
    {
        log.info(String.format("Got [GET] request with body %s", movieRequest.toString()));

        String requestURI = UriComponentsBuilder.fromHttpUrl(apiUrl)
                .queryParam("apikey", apiKey)
                .queryParam("t", movieRequest.getSearchKeyword())
                .queryParam("y", movieRequest.getYear())
                .build(false).toUriString();

        OMDBApiResponce response = restTemplate.getForObject(requestURI, OMDBApiResponce.class);

        log.info(String.format("Made %s request, got answer with body %s", requestURI, response.toString()));

        return response;
    }
}
