package com.gdn.springintro.springintro;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

// mark -> mark class as a candidate of Bean
// Bean -> Object but manage by Spring (create, destroy, or the lifecycle is manage by Spring)
@Component
public class StarwarsMovie {
    public List<String> getMovies() {
        List<String> movies = new ArrayList<>();
        movies.add("Starwars Episode 1");
        movies.add("Starwars Episode 11");
        return movies;
    }
}
