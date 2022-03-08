package com.gdn.springintro.springintro.controller;

import com.gdn.springintro.springintro.web.request.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// Enable integration in spring
// SpringBootTest.WebEnvironment.RANDOM_PORT -> tell spring to run the test on real web environment
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

// If application context need to renew or clear for every test
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class TheaterAppControllerTest {

    // Make sure test is same with QA
    // Method test name format: {feature}_{condition}_{expectedResult}

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void getMovies_success_shouldReturnEmptyResult() {

        // 1. specify method & endpoint
        // 2. exchange (execute endpoint)
        // 3. assert HTTP status result
        // 4. assert HTTP response as expected

        webTestClient.get()
                .uri("/movies")
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBody(new ParameterizedTypeReference<List<Movie>>() {})
                .value(movies -> assertTrue(movies.isEmpty()));
    }

    @Test
    public void addMovies_shouldAddNewMovieData() {

        Movie movieRequest = new Movie();
        movieRequest.setId("mv-1");
        movieRequest.setMovieName("Spiderman");

        Movie expectedResult = new Movie();
        expectedResult.setId("mv-1");
        expectedResult.setMovieName("Spiderman");

        webTestClient.post()
                .uri("/movies")
                .body(Mono.just(movieRequest), Movie.class)
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBody(Movie.class)
                .value(mv -> {
                    assertEquals(mv.getId(), expectedResult.getId());
                    assertEquals(mv.getMovieName(), expectedResult.getMovieName());
                });

        webTestClient.get()
                .uri("/movies")
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBody(new ParameterizedTypeReference<List<Movie>>() {})
                .value(movies -> assertEquals(1, movies.size()));

//        webTestClient.method(HttpMethod.DELETE)
//                .uri("/movies")
//                .body()

    }


}