package com.gdn.springintro.springintro.client;

import com.gdn.springintro.springintro.client.response.SwapiMovie;
import com.gdn.springintro.springintro.client.response.SwapiResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class SwapiAPIClient {
    public WebClient setUp() {
        return WebClient.builder()
                .baseUrl("https://swapi.dev/api/")
                .build();
    }

    public List<SwapiMovie> getMovies() {
        WebClient client = setUp();

        SwapiResponse response = client.get()
                .uri("films/")
                .retrieve()
                .bodyToMono(SwapiResponse.class)
                .block();

        return response.getResults();
    }
}
