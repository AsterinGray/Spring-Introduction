package com.gdn.springintro.springintro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TheaterApp {

//    1. Inject dependency from spring via filed injection
//    @Autowired
//    private StarwarsMovie starwarsMovie;

    // 2. Inject dependency from spring via constructor injection
    // 2.1. Component Scan
    private StarwarsMovie starwarsMovie;
    // 2.2. Bean Configuration
    // Use case
    // -> we can't add @Component annotation to class
    // -> to add something to the configuration
    private MarvelMovie marvelMovie;

    public TheaterApp(StarwarsMovie starwarsMovie, MarvelMovie marvelMovie) {
        this.starwarsMovie = starwarsMovie;
        this.marvelMovie = marvelMovie;
    }

    public void showHomepage() {
        System.out.println("==============================");
        System.out.println("Starwars Movie");
        System.out.println("===========================");

        System.out.println("List Movies: ");

        List<String> starwarsMovies = starwarsMovie.getMovies();
        starwarsMovies.forEach(mv -> System.out.println(mv));

        List<String> marvelMovies = marvelMovie.getMovies();
        marvelMovies.forEach(mv -> System.out.println(mv));
    }

}
