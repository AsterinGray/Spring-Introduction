package com.gdn.springintro.springintro;

import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;

public class MarvelMovie {

    @Value("${marvel.trending.movie}")
    private String trendingMovie;

    public List<String> getMovies() {
        List<String> movies = new ArrayList<>();
        movies.add("Spiderman no way home");
        movies.add(trendingMovie);
        return movies;
    }
}
