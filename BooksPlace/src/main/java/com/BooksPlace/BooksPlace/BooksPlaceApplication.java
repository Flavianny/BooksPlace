package com.BooksPlace.BooksPlace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class BooksPlaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksPlaceApplication.class, args);
	}
	
//	@Bean
//	public LocaleResolver localeResolver() {
//		return new FixedLocaleResolver(new Locale("pt", "BR"));
//	}

}

