package io.amras.mainclientserver.controller;

import io.amras.mainclientserver.model.MovieRequest;
import io.amras.mainclientserver.model.OMDBApiResponce;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@Log4j2
public class MainController {

    @Value("${services.omdb.api.url}")
    private String apiUrl;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/")
    public String start(Model model)
    {
        log.info("Main page loaded");

        model.addAttribute("movieRequest", new MovieRequest());

        return "main_page";
    }

    @PostMapping("/")
    public String findMovie(@ModelAttribute MovieRequest movieRequest, Model model)
    {
        log.info(String.format("Sending [GET] to %smovie with body = %s", apiUrl, movieRequest.toString()));

        OMDBApiResponce response = restTemplate.postForObject(apiUrl + "movie", movieRequest, OMDBApiResponce.class);

        log.info(String.format("Got answer response = %s", response.toString()));

        model.addAttribute("movieRequest", new MovieRequest());
        model.addAttribute("movieInfo", response);

        return "main_page";
    }

}
