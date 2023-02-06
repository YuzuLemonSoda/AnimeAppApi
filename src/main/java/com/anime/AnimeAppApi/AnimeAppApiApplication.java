package com.anime.AnimeAppApi;

import com.anime.AnimeAppApi.entity.Anime;
import com.anime.AnimeAppApi.repository.AnimeRepository;
import com.anime.AnimeAppApi.service.AnimeService;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.objectweb.asm.TypeReference;
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

	@Autowired
	private AnimeRepository animeRepository;

	public static void main(String[] args) {
		SpringApplication.run(AnimeAppApiApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(AnimeService animeService) {

//		Anime first = new Anime("41467", "Bleach: Sennen Kessen-hen", new String[] {"Bleach: Thousand-Year Blood War Arc", "BLEACH 千年血戦篇", "Bleach: Thousand-Year Blood War"}, 1L, new String[] {"Action", "Adventure", "Fantasy"}, 0L, false, true, "https://cdn.myanimelist.net/images/anime/1764/126627.jpg", "https://myanimelist.net/anime/41467/Bleach__Sennen_Kessen-hen", "Not yet aired", "Synopsis", "https://cdn.myanimelist.net/r/50x70/images/anime/1764/126627.jpg?s=196ea098ac1becd97fc0a4b50a949c2b", "TV");
//
//		animeRepository.save(first);

		return args -> {

			// read json and write to db
			ObjectMapper mapper = new ObjectMapper();
			JavaType type = mapper.getTypeFactory().constructCollectionType(List.class, Anime.class);
//			List<Anime> list = mapper.readValue(new File("src/main/resources/AnimeDB_Data.json"), type);
			InputStream inputStream = TypeReference.class.getResourceAsStream("src/main/resources/AnimeDB_Data.json");
			try {
				List<Anime> animeList = mapper.readValue(inputStream, type);
				animeService.save(animeList);
				System.out.println("Anime saved!");

			} catch (IOException e) {
				System.out.println("Unable to save anime: " + e.getMessage());
			}
		};

	}
}
