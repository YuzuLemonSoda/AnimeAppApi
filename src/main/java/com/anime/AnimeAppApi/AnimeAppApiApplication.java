package com.anime.AnimeAppApi;

import com.anime.AnimeAppApi.entity.Anime;
import com.anime.AnimeAppApi.repository.AnimeRepository;
import com.anime.AnimeAppApi.service.AnimeService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class AnimeAppApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnimeAppApiApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(AnimeService animeService) {

		return args -> {

			// read json and write to db
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Anime>> typeReference = new TypeReference<List<Anime>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/AnimeDB_Data.json");
			try {
				List<Anime> animeList = mapper.readValue(inputStream, typeReference);
				animeService.save(animeList);
				System.out.println("Anime saved!");

			} catch (IOException e) {
				System.out.println("Unable to save anime: " + e.getMessage());
			}
		};
	}

}
