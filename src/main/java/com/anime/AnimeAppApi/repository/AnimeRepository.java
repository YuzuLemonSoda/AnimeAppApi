package com.anime.AnimeAppApi.repository;

import com.anime.AnimeAppApi.model.Anime;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AnimeRepository extends MongoRepository<Anime, String> {

    List<Anime> findByTitle(String title);

}
