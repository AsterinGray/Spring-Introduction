package com.gdn.springintro.springintro.service;

import com.gdn.springintro.springintro.web.request.Movie;

import java.util.List;

public interface MovieProvider {
    List<Movie> getMovies();
    Movie addMovie(Movie movie);
    Movie editMovie(Movie movie);
    boolean deleteMovie(String id);
}
