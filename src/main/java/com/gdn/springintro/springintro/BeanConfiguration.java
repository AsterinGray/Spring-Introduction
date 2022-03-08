package com.gdn.springintro.springintro;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// mark class as source of bean
@Configuration
public class BeanConfiguration {

    // create bean with MarvelMovie type
    @Bean
    public MarvelMovie marvelMovie() {
        return new MarvelMovie();
    }
}
