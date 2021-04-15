package io.amras.mainclientserver.controller;

import io.amras.mainclientserver.model.MovieRequest;
import io.amras.mainclientserver.model.MoviedbSearchMovieResponse;
import io.amras.mainclientserver.model.OMDBApiResponce;
import io.amras.mainclientserver.service.MainService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Log4j2
public class MainController {

    @Autowired
    MainService mainService;

    @GetMapping("/")
    public String start(Model model) {
        log.info("Main page loaded");

        model.addAttribute("movieRequest", new MovieRequest());

        return "main_page";
    }

    @PostMapping("/")
    public String findMovie(@ModelAttribute MovieRequest movieRequest, Model model) {
        MoviedbSearchMovieResponse response = mainService.findMovie(movieRequest);

        model.addAttribute("movieRequest", new MovieRequest());
        model.addAttribute("moviesInfo", response);

        return "main_page";
    }

    @GetMapping("/{movie_id}")
    public String getMovieById(@PathVariable("movie_id") int movieId, Model model) {
        String imdbId = mainService.getMovieImdbId(movieId);
        OMDBApiResponce response = mainService.getMovieInfoByImdbId(imdbId);

        model.addAttribute("movieInfo", response);

        return "movie_page";
    }

}
