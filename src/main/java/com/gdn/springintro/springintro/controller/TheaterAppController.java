package com.gdn.springintro.springintro.controller;

import com.gdn.springintro.springintro.service.MovieProvider;
import com.gdn.springintro.springintro.web.request.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// Mark class as rest controller
@RestController
public class TheaterAppController {
    // Aplikasi dalam bentuk CRUD
    // 4 endpoint GET, POST, PUT, DELETE

    @Autowired
    MovieProvider movieProvider;

    @GetMapping("movies")
    public List<Movie> getMovies() {
        return movieProvider.getMovies();
    }

    @PostMapping("movies")
    public Movie addMovie(@RequestBody Movie movie) {
        return movieProvider.addMovie(movie);
    }

    @PutMapping("movies")
    public Movie editMovie(@RequestBody Movie movie) {
        return movieProvider.editMovie(movie);
    }

    @DeleteMapping("movies")
    public boolean deleteMovie(@RequestBody Map<String, String> id) {
        return movieProvider.deleteMovie(id.get("id"));
    }
}
