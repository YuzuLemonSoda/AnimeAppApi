package com.anime.AnimeAppApi;

import com.anime.AnimeAppApi.jikan.model.full.Root;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class AnimeAppApiApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(AnimeAppApiApplication.class, args);

//		JikanApiAnimeGetTop5();
//		JikanApiAnimeSeasonNow();
	}

	public static void JikanApiAnimeGetTop5() throws IOException, InterruptedException{
			int[] jikanAnimeId = {51535, 5114, 41467, 9253, 28977};
			List<Root> list = new ArrayList<Root>();
			ObjectMapper mapper = new ObjectMapper();

			for(int i = 0; i < jikanAnimeId.length; i++) {

				String url = String.format("https://api.jikan.moe/v4/anime/%2d/full", jikanAnimeId[i]);

				HttpClient client = HttpClient.newHttpClient();
				HttpRequest request = HttpRequest.newBuilder()
						.uri(URI.create(url))
						.header("Accept", "application/json")
						.timeout(Duration.ofSeconds(15))
						.build();

				HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

				System.out.println(response.body());

				mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

				Root obj = mapper.readValue(response.body(), Root.class);
				System.out.println(obj);
				list.add(obj);
				ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

				writer.writeValue(new File("src/main/resources/json/Jikan_Anime.json"), obj);
			}


			ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
			String jikanAnimeJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
			System.out.println(jikanAnimeJson);
			writer.writeValue(new File("src/main/resources/json/Jikan_Anime.json"), list);

			System.exit(0);
		}

	public static void JikanApiAnimeSeasonNow() throws IOException, InterruptedException {

		List<com.anime.AnimeAppApi.jikan.model.seasonNow.Root> list = new ArrayList<>();
		ObjectMapper mapper = new ObjectMapper();
		int[] pages = {1, 2, 3};

		for(int i = 0; i < pages.length; i++) {
			String url = String.format("https://api.jikan.moe/v4/seasons/now?page=%d", pages[i]);

			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create(url))
					.header("Accept", "application/json")
					.timeout(Duration.ofSeconds(15))
					.build();

			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

			System.out.println(response.body());

			com.anime.AnimeAppApi.jikan.model.seasonNow.Root roots = mapper.readValue(response.body(), com.anime.AnimeAppApi.jikan.model.seasonNow.Root.class);
			System.out.println(roots);
			list.add(roots);
			ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

			writer.writeValue(new File("src/main/resources/json/Jikan_Anime_Season_Now.json"), roots);

		}

		ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
		String jikanAnimeJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
		System.out.println(jikanAnimeJson);
		writer.writeValue(new File("src/main/resources/json/Jikan_Anime_Season_Now.json"), list);

		System.exit(0);
	}

}
