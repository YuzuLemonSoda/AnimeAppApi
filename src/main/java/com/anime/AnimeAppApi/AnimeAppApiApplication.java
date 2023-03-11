package com.anime.AnimeAppApi;

import com.anime.AnimeAppApi.jikan.model.Root;
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

		int[] jikanAnimeId = {5114, 41467};
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
//			String jikanAnimeJson = mapper.writeValueAsString(obj);
//			String jikanAnimeJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
//			System.out.println(jikanAnimeJson);
			writer.writeValue(new File("src/main/resources/json/Jikan_Anime.json"), obj);
//			System.out.println("File has been Saved!");
		}


		ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
		String jikanAnimeJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
		System.out.println(jikanAnimeJson);
		writer.writeValue(new File("src/main/resources/json/Jikan_Anime.json"), list);

		System.exit(0);
	}

}
