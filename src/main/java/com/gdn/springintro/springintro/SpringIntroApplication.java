package com.gdn.springintro.springintro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringIntroApplication {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringIntroApplication.class, args);
		context.getBean(TheaterApp.class).showHomepage();
	}
}
